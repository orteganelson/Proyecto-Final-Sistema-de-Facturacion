/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IClienteDao;
import ec.edu.ups.modelo.Cliente;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ClienteDao implements IClienteDao {

    /**
     * Estructura del Archivo private String cedula; 10 caracteres + 2 bytes
     * extras private String nombre; 25 caracteres + 2 bytes extras private
     * String apellido; 25 caracteres + 2 bytes extras private String correo; 50
     * caracterres + 2 bytes extras private String direccion; 60 caracteres + 2
     * bytes extras private String telefono; 25 caracteres + 2 bytes extras
     * private int codigoFactura ; 4 bytes 195 bytes mas 12 bytes por String =
     * 207 bytes por registro
     *
     * @param cliente
     */
    private int tamanioRegistro;
    private RandomAccessFile archivo;

 

    public ClienteDao() {
       
        this.tamanioRegistro = 207;
        try {
            archivo = new RandomAccessFile("datos/clientes.dat", "rw");
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");

        }
    }

    @Override
    public void create(Cliente cliente) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(cliente.getCedula());
            archivo.writeUTF(cliente.getNombre());
            archivo.writeUTF(cliente.getApellido());
            archivo.writeUTF(cliente.getCorreo());
            archivo.writeUTF(cliente.getDireccion());
            archivo.writeUTF(cliente.getTelefono());

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura create");
        }
    }

    @Override
    public Cliente read(String cedula) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaA = archivo.readUTF().trim();
                if (cedula.trim().equals(cedulaA)) {
                    // retornar el Usuario
                    Cliente cliente = new Cliente(cedula.trim(), archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim());
         
                    return cliente;
                }

                salto += tamanioRegistro;
            }

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura read:ClienteoDao");
        }
        return null;

    }

    @Override
    public void update(Cliente cliente) {
        int salto = 0;
        String cedula = cliente.getCedula();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF().trim();
                if (cedula.trim().equals(cedulaArchivo)) {
                    //archivo.writeUTF(cliente.getCedula());
                    archivo.writeUTF(cliente.getNombre());
                    archivo.writeUTF(cliente.getApellido());
                    archivo.writeUTF(cliente.getCorreo());
                    archivo.writeUTF(cliente.getDireccion());
                    archivo.writeUTF(cliente.getTelefono());
                    break;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura(Update: ClienteDao)");
        }
    }

    @Override
    public void delete(Cliente cliente) {
        try {
            String cedula = cliente.getCedula();
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                String cedulaArchivo = archivo.readUTF();
                if (cedula.trim().equals(cedulaArchivo.trim())) {
                    archivo.seek(salto);
                    archivo.writeUTF(llenarEspacios(10));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(50));
                    archivo.writeUTF(llenarEspacios(60));
                    archivo.writeUTF(llenarEspacios(25));
    
                    break;
                }
                salto += tamanioRegistro;
            }

        } catch (IOException ex) {
            System.out.println("Error : Delete : ClienteDao");
        }
    }

    public String llenarEspacios(int espacios) {
        String aux = "";
        return String.format("%-" + espacios + "s", aux);
    }

    @Override
    public List<Cliente> listarTodosClientes() {

        List<Cliente> listaClientes = new ArrayList<>();
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);

                String  cedulaA = archivo.readUTF().trim();
                if ("".equals(cedulaA)) {
                } else {
                    Cliente cliente = new Cliente(cedulaA, archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim());
                    listaClientes.add(cliente);
                }

                salto += tamanioRegistro;
            }
            return listaClientes;
        } catch (IOException ex) {
            System.out.println("error listarTodosClientes : ClienteDao");
        }
        return listaClientes;

    }

}

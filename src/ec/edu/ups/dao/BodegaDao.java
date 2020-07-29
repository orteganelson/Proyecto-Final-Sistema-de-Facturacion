/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IBodegaDao;
import ec.edu.ups.modelo.Bodega;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class BodegaDao implements IBodegaDao {

    /**
     * Estructtura del Archivo private int codigo; 4 bytes private String
     * nombre; 25 caracteres + 2 extras private String direccion; 60 caracteresw
     * + 2 extras private String ciudad; 25 caracteres + 2 extras private int
     * cantidad; 4 bytes private 118 bytes + 6 bytes por string = 124 bytes por
     * registro
     */
    private int codigo;
    private int tamanioRegistro;
    private RandomAccessFile archivo;

    public BodegaDao() {
        codigo = 0;
        this.tamanioRegistro = 124;
        try {
            archivo = new RandomAccessFile("datos/bodegas.dat", "rw");
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura: BodegaDao");

        }

    }

    @Override
    public void create(Bodega bodega) {
        try {
            archivo.seek(archivo.length());
            archivo.writeInt(bodega.getCodigo());
            archivo.writeUTF(bodega.getNombre());
            archivo.writeUTF(bodega.getDireccion());
            archivo.writeUTF(bodega.getCiudad());
            archivo.writeInt(bodega.getCantidad());

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura create: BodegaDao");
        }
    }

    @Override
    public Bodega read(int codigo) {
        int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == codigo) {
                    Bodega bodega = new Bodega(codigoA, archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readInt());

                    return bodega;
                }

                salto += tamanioRegistro;
            }

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura read:BodegaDao");
        }
        return null;

    }

    @Override
    public void update(Bodega bodega) {
        int salto = 0;
        int codi = bodega.getCodigo();
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == codi) {

                    archivo.writeUTF(bodega.getNombre());
                    archivo.writeUTF(bodega.getDireccion());
                    archivo.writeUTF(bodega.getCiudad());
                    archivo.writeInt(bodega.getCantidad());

                    break;
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura o escritura Update :BodegaDao");
        }
    }

    @Override
    public void delete(Bodega bodega) {
        try {
            int codi = bodega.getCodigo();
            int salto = 0;
            while (salto < archivo.length()) {
                archivo.seek(salto);
                int codigoA = archivo.readInt();
                if (codigoA == codi) {
                    archivo.seek(salto);
                    archivo.writeInt(0);
                    archivo.writeUTF(llenarEspacios(25));
                    archivo.writeUTF(llenarEspacios(60));
                    archivo.writeUTF(llenarEspacios(60));
                    archivo.writeInt(0);
                    break;
                }
                salto += tamanioRegistro;
            }

        } catch (IOException ex) {
            System.out.println("Error  Delete : BodegaDao");
        }
    }

    public String llenarEspacios(int espacios) {
        String aux = "";
        return String.format("%-" + espacios + "s", aux);
    }

    @Override
    public List<Bodega> listarTodasBodegas() {
        List<Bodega> listaBodegas = new ArrayList<>();
        try {
            int salto = 0;

            while (salto < archivo.length()) {
                archivo.seek(salto);

                int valor = archivo.readInt();
                if (valor > 0) {

                    Bodega bodega = new Bodega(valor, archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readInt());
                    listaBodegas.add(bodega);

                }

                salto += tamanioRegistro;
            }
            return listaBodegas;
        } catch (IOException ex) {
            System.out.println("error listarTodosProductos : ProductoDao");
        }
        return listaBodegas;

    }

    @Override
    public int obtenerUltimoCodigo() {
        try {
            if (archivo.length() >= tamanioRegistro) {
                archivo.seek(archivo.length() - tamanioRegistro);
                codigo = archivo.readInt();
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");
        }

        return codigo;
    }

}

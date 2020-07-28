/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IUsuarioDao;
import ec.edu.ups.modelo.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;



/**
 *
 * @author 
 */
public class UsuarioDao implements IUsuarioDao {

    /**
     * Estructura del archivo
     *
     * private String Cedula| 10 bytes, ValidarCedula +2 bytes extras private
     * String nombre| 25 caracteres , Llenar con espacios, cortar a 25
     * caracteres +2 bytes extras private String apellido| 25 caracteres, Llenar
     * con espacios, cortar a 25 caracteres+2 bytes extras private String
     * correo| 50 caracteres , Llenar con espacios, cortar a 50 caracteres +2
     * bytes extras private String contrasena| 8 caracteres Validar contraseña+2
     * bytes extras 118 bytes mas 10 bytes por String = 128 bytes private
     * listaTelefonos;
     *
     */
    private int tamanioRegistro ;
    private RandomAccessFile archivo;

    public UsuarioDao() {
           tamanioRegistro=128;
        try {
            archivo = new RandomAccessFile("datos/usuarios.dat", "rw");
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura");

        }
    }

    @Override
    public void create(Usuario usuario) {
        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(usuario.getCedula());
            archivo.writeUTF(usuario.getNombre());
            archivo.writeUTF(usuario.getApellido());
            archivo.writeUTF(usuario.getCorreo());
            archivo.writeUTF(usuario.getContrasena());
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura create");
        }

    }

    @Override
    public Usuario read(String cedula) {
       int salto = 0;
        try {
            while (salto < archivo.length()) {
                archivo.seek(salto);
                     String cedulaA=archivo.readUTF().trim();
                if (cedula.trim().equals(cedulaA)) {
                    // retornar el Usuario
                     Usuario usuario = new Usuario(cedula.trim(), archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim());
                    return usuario;
                }
                
                salto += tamanioRegistro;
            }

        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura read:TelefonoDao");
        }
        return null;
      

    }

    @Override
    public void update(Usuario usuario) {

    }

    @Override
    public void delete(Usuario usuario) {

    }

    @Override
    public Usuario iniciarSesion(String correo, String contraseña) {
        try {
            int salto = 66;

            while (salto < archivo.length()) {
                archivo.seek(salto);
                String correoArchivo = archivo.readUTF();
                String contraArchivo = archivo.readUTF();

                if (correo.equals(correoArchivo.trim()) && contraseña.equals(contraArchivo.trim())) {
                    archivo.seek(salto - 66);

                    return new Usuario(archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF(), archivo.readUTF());
                }
                salto += tamanioRegistro;
            }
        } catch (IOException ex) {
            System.out.println("Error de lectura y escritura login");
        }
        return null;
    }

    @Override
    public List< Usuario> listarTodosUsuarios() {
        return null;
       
    }

}

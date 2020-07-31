/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.idao.IUsuarioDao;
import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 * Clase ControladorUsuario.
 *
 * Esta clase manejara toda la informacion del usuario y ademas tendra acceso a
 * la lista de usuarios registrados que le pertenece a UsuarioDao, esto se debe
 * a que el cosntructor recibe al usuarioDao.
 *
 *
 * @author
 */
public class ControladorUsuario {

    private Usuario usuario;
    private IUsuarioDao UsuarioDao;

    public ControladorUsuario(UsuarioDao usuarioDAO) {
        this.UsuarioDao = usuarioDAO;
    }

    public void registrarUsuario(String cedula, String nombre, String apellido, String correo, String pass) {
        usuario = new Usuario(cedula, nombre, apellido, correo, pass);
        UsuarioDao.create(usuario);

    }

    public void actualizarUsuario(String cedula, String nombre, String apellido, String correo, String pass) {
        usuario = new Usuario(cedula, nombre, apellido, correo, pass);
        UsuarioDao.update(usuario);
    }

    public void eliminarUsuario(String cedula) {
        usuario = UsuarioDao.read(cedula);
        UsuarioDao.delete(usuario);
    }

    public void buscarUsuario(String cedula) {
        UsuarioDao.read(cedula);
    }

    public Usuario iniciarSesion(String correo, String contrasena) {
        usuario = UsuarioDao.iniciarSesion(correo, contrasena);

        return usuario;
    }
        public boolean validarUsuario(String correo, String pass) {
        usuario = UsuarioDao.iniciarSesion(correo, pass);
        if (usuario != null) {
            return true;
        } else {
            return false;
        }
      

    }
      public List<Usuario> listarUsuarios(){
        return UsuarioDao.listarTodosUsuarios();
        
        }
}

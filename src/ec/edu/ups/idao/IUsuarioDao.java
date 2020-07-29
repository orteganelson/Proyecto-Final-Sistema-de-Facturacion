/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Usuario;
import java.util.List;

/**
 *
 * @author paul_
 */
public interface IUsuarioDao {

    public void create(Usuario usuario);

    public Usuario read(String correo);

    public void update(Usuario usuario);

    public void delete(Usuario usuario);

    public List<Usuario> listarTodosUsuarios();

    public Usuario iniciarSesion(String correo, String contraseña);

}

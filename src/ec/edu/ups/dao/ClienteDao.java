/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IClienteDao;
import ec.edu.ups.modelo.Cliente;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ClienteDao implements IClienteDao {
    /**
     * Estructura del Archivo
     * private String nombre; 25 caracteres + 2 bytes extras
     * private String apellido; 25 caracteres + 2 bytes extras
     * private String cedula; 10 caracteres + 2 bytes extras
     * private String correo; 50 caracterres + 2 bytes extras
     * private String direccion; 60 caracteres + 2 bytes extras
     * private String telefono;
     */
    @Override
    public void create(Cliente cliente) {
        
    }

    @Override
    public Cliente read(String cedula) {
        return null;
       
    }

    @Override
    public void update(Cliente cliente) {
        
    }

    @Override
    public void delete(Cliente cliente) {
        
    }

    @Override
    public List<Cliente> listarTodosClientes() {
        return null;
      
    }
    
}

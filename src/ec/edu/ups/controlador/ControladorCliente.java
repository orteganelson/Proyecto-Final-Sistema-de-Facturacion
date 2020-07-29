/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.ClienteDao;
import ec.edu.ups.dao.DetalleDao;
import ec.edu.ups.dao.FacturaDao;
import ec.edu.ups.dao.ProductoDao;
import ec.edu.ups.idao.IClienteDao;
import ec.edu.ups.idao.IDetalleDao;
import ec.edu.ups.idao.IFacturaDao;
import ec.edu.ups.idao.IProductoDao;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Factura;

/**
 *
 * @author Usuario
 */
public class ControladorCliente {
    
    private IClienteDao clienteDao;
    private IFacturaDao facturaDao;
    private IDetalleDao detalleDao;
    private IProductoDao productoDao;

    public ControladorCliente(ClienteDao clienteDao, FacturaDao facturaDao,DetalleDao detalleDao, ProductoDao productoDao) {
        this.clienteDao = clienteDao;
        this.facturaDao = facturaDao;
        this.detalleDao=detalleDao;
        this.productoDao=productoDao;
    }
    
    /**
     *
     * @param cedula
     * @param nombre
     * @param apellido
     * @param correo
     * @param direccion
     * @param telefono
     */
    public void registrarCliente (String cedula, String nombre, String apellido, String correo, String direccion, String telefono){
     Cliente cliente;
        cliente = new Cliente (cedula,nombre,apellido,correo,direccion,telefono);
        clienteDao.create(cliente);
    }
    
    public void actualizarCliente (String cedula, String nombre, String apellido, String correo, String direccion, String telefono){
     Cliente cliente;
        cliente = new Cliente (cedula,nombre,apellido,correo,direccion,telefono);
        clienteDao.update(cliente);
    }
    
    public void eliminarCliente (String cedula){
    Cliente cliente= clienteDao.read(cedula);
    clienteDao.delete(cliente);
    }
    
    public Cliente buscarCliente (String cedula){
        Cliente cliente = clienteDao.read(cedula);
        return cliente;
    }
    
    public void agregarFactura (int codigo, String numero, String estado, double subtotal, double iva, double valorAPagar, String cedula){
    Factura factura = new Factura(codigo,numero,estado,subtotal,iva,valorAPagar);
    Cliente cliente =clienteDao.read(cedula);
    factura.setCliente(cliente);
    facturaDao.create(factura);
    Detalle detalle = detalleDao.buscarPorFactura(factura.getNumero());
    productoDao.disminuirStock(detalle);
    }
    
   
}

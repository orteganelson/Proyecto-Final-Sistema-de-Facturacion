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
import ec.edu.ups.modelo.Producto;

/**
 *
 * @author Juanc
 */
public class ControladorFactura {
    
   private IFacturaDao facturaDao;
   private IClienteDao clienteDao;
   private IDetalleDao detalleDao;
   private IProductoDao productoDao;

    public ControladorFactura(FacturaDao facturaDao,DetalleDao detalleDao, ProductoDao productoDao, ClienteDao clienteDao) {
        this.facturaDao = facturaDao;
        this.detalleDao=detalleDao;
        this.productoDao=productoDao;
        this.clienteDao=clienteDao;
    }
   public void crearFactura(int codigo, String numero, String estado,String fecha, double subtotal, double iva, double valorAPagar,String cedula){
       Factura factura= new Factura(codigo,numero,estado,fecha,subtotal,iva,valorAPagar);
      Cliente cliente = clienteDao.read(cedula);
      factura.setCliente(cliente);
       
   facturaDao.create(factura);
   
   }
 
    public void anularFactura (Factura factura){
        facturaDao.anularFactura(factura);
        Detalle detalle =  detalleDao.buscarPorFactura(factura.getNumero());
        productoDao.aumentarStock(detalle);
    }
    public void agregarDetalle(int codigo,int codigoProducto ,int cantidad, String numeroFactura){
        Detalle detalle = new Detalle(codigo,cantidad);
        Producto producto= productoDao.read(codigoProducto);
       detalle.setTotal(cantidad*producto.getPrecio());
        detalle.setProducto(producto);
        Factura factura = new Factura();
        factura.setNumero(numeroFactura);
        detalle.setFactura(factura);
        detalleDao.create(detalle);
    
    }
    public void eliminarDetalle(int codigo){
       Detalle detalle= detalleDao.read(codigo);
     detalleDao.Delete(detalle);
    }
      public void actualizarDetalle(int codigo, int cantidad, double total, String numeroFactura){
        Detalle detalle = new Detalle(codigo,cantidad);
        Factura factura = facturaDao.buscarPorNumero(numeroFactura);
        detalle.setFactura(factura);
        detalleDao.Update(detalle);
    
    }
      public int obtenerSiguienteCodigo() {
        int codigo = facturaDao.obtenerUltimoCodigo();

        return codigo;
    }
      
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.DetalleDao;
import ec.edu.ups.dao.ProductoDao;
import ec.edu.ups.idao.IDetalleDao;
import ec.edu.ups.idao.IFacturaDao;
import ec.edu.ups.idao.IProductoDao;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Factura;
import ec.edu.ups.modelo.Producto;
import java.util.List;

/**
 *
 * @author Juanc
 */
public class ControladorDetalle {
    
   private IDetalleDao detalleDao;
   private IProductoDao productoDao;
   private IFacturaDao  facturaDao;

    public ControladorDetalle(DetalleDao detalleDao, ProductoDao productoDao) {
        this.detalleDao = detalleDao;
        this.productoDao = productoDao;
    }
   
   
   
   public void crearDetalle (int codigo, int cantidad,  int codigoProducto){
   Detalle detalle = new Detalle(codigo,cantidad);
  
   Producto producto= productoDao.read(codigoProducto);
    detalle.setTotal(cantidad*producto.getPrecio());
   detalle.setProducto(producto);
   detalleDao.create(detalle);
  
   }
   
  public void eliminarDetalle (int codigo){
  Detalle detalle= detalleDao.read(codigo);
  detalleDao.Delete(detalle);
  }
  public void actualizarDetalle(int codigo, int cantidad, double total, int codigoProducto){
  Detalle detalle = new Detalle(codigo,cantidad);
   Producto producto= productoDao.read(codigoProducto);
    detalle.setTotal(cantidad*producto.getPrecio());
   detalle.setProducto(producto);
   detalleDao.Update(detalle);
  }
  public List<Detalle> Detalles (){
       return detalleDao.listaDetalles();
  
  }
  public int obtenerSiguienteCodigo() {
        int codigo = detalleDao.obtenerUltimoCodigo();

        return codigo;
    }
  public Double obtenerSubtotal(String numero){
      double subtotal=0;
      List<Detalle> detalles= detalleDao.listaDetalles();
   for (Detalle detalle: detalles){
       if(detalle.getFactura().getNumero().trim().equals(numero.trim())){
       subtotal+=detalle.getTotal();
       }
   
   }
       return subtotal;
  
  }
}

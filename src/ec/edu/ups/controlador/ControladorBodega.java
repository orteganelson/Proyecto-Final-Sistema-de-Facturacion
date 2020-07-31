/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.BodegaDao;
import ec.edu.ups.dao.ProductoDao;
import ec.edu.ups.modelo.Bodega;
import java.util.List;

/**
 *
 * @author Juanc
 */
public class ControladorBodega {
  private ProductoDao productoDao;
 private Bodega bodega;
  private BodegaDao bodegaDao;
  
  public ControladorBodega( BodegaDao bodegaDao , ProductoDao productoDao) {
        this.bodegaDao = bodegaDao;
        this.productoDao=productoDao;
    }
  
  public void crearBodega(int codigo, String nombre, String direccion, String ciudad){
  this.bodega= new Bodega (codigo,nombre,direccion,ciudad);
  bodegaDao.create(bodega);
  }
  
  public void eliminarBodega(int codigo){
  Bodega bode= bodegaDao.read(codigo);
  bodegaDao.delete(bode);
  }
  
  public void actualizarBodega(int codigo, String nombre, String direccion, String ciudad){
   this.bodega= new Bodega (codigo,nombre,direccion,ciudad);
  bodegaDao.update(bodega);
  }
  public int obtenerStockBodega(String nombreBodega){
      Bodega b = bodegaDao.buscarPorNombre(nombreBodega);
      return productoDao.obtenerStockBodega(b.getCodigo());
  
  }
 public Bodega buscarPorNombre (String nombre){
      return bodegaDao.buscarPorNombre(nombre);
 
 }
  public void actualizarStock(String nombre){
      
  bodegaDao.updateStock(obtenerStockBodega(nombre), nombre);
  }
  public List<Bodega> listarBodegas(){
     return bodegaDao.listarTodasBodegas();
  
  }
      public int obtenerSiguienteCodigo() {
        int codigo =  bodegaDao.obtenerUltimoCodigo();

        return codigo;
    }
}

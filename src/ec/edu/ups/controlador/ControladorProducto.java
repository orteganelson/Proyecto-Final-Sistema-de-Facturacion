/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.BodegaDao;
import ec.edu.ups.dao.ProductoDao;
import ec.edu.ups.modelo.Bodega;
import ec.edu.ups.modelo.Producto;
import java.util.List;

/**
 *
 * @author Juanc
 */
public class ControladorProducto {
    private Bodega bodega;
    private Producto producto;
    private BodegaDao bodegaDao;
    private ProductoDao productoDao;

    public ControladorProducto (BodegaDao bodegaDao, ProductoDao productoDao) {
        this.bodegaDao = bodegaDao;
        this.productoDao = productoDao;
    }
    
    public void crearProducto (int codigo, String nombre, double precio, int cantidad, String descripcion, int codigoBodega){
        this.producto= new Producto(codigo,nombre,precio,cantidad,descripcion);
        bodega=this.bodegaDao.read(codigoBodega);
        producto.asignarBodega(bodega);
        productoDao.create(producto);
        
    }
    
    public void eliminarProducto(Producto producto){
        productoDao.delete(producto);
    }
    public Producto buscarProducto (int codigo){
        Producto prod = productoDao.read(codigo);
    return prod;
    }
    public void actualizarProducto(int codigo, String nombre, double precio, int cantidad, String descripcion, int codigoBodega){
         this.producto= new Producto(codigo,nombre,precio,cantidad,descripcion);
        bodega=this.bodegaDao.read(codigoBodega);
        producto.asignarBodega(bodega);
        productoDao.update(producto);
    }
    
    public List<Producto> listarProductos(){
        return productoDao.listarTodosProductos();
    
    }
    public List<Producto> listarProductosBodega(int codigoBodega){
        return productoDao.listarPorBodega(codigoBodega);
    
    }
      public int obtenerSiguienteCodigo() {
        int codigo =  productoDao.obtenerUltimoCodigo();

        return codigo;
    }
}

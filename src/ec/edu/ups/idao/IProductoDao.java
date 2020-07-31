/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Producto;
import java.util.List;

/**
 *
 * @author paul_
 */
public interface IProductoDao {

    public void create(Producto producto);

    public Producto read(int codigo);

    public void update(Producto producto);

    public void delete(Producto producto);

    public int obtenerUltimoCodigo();
    
    public int obtenerStockBodega(int codigo);

    public void disminuirStock(Detalle detalle);

    public void aumentarStock(Detalle detalle);

    public List<Producto> listarTodosProductos();

    public List<Producto> listarPorBodega(int codigo);

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.DetalleDao;
import ec.edu.ups.dao.FacturaDao;
import ec.edu.ups.dao.ProductoDao;
import ec.edu.ups.idao.IDetalleDao;
import ec.edu.ups.idao.IFacturaDao;
import ec.edu.ups.idao.IProductoDao;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Factura;

/**
 *
 * @author Juanc
 */
public class ControladorFactura {
    
   private IFacturaDao facturaDao;
   private IDetalleDao detalleDao;
   private IProductoDao productoDao;

    public ControladorFactura(FacturaDao facturaDao,DetalleDao detalleDao, ProductoDao productoDao) {
        this.facturaDao = facturaDao;
        this.detalleDao=detalleDao;
        this.productoDao=productoDao;
    }
   
    public void anularFactura (Factura factura){
        facturaDao.anularFactura(factura);
        Detalle detalle =  detalleDao.buscarPorFactura(factura.getNumero());
        productoDao.aumentarStock(detalle);
    }
      public int obtenerSiguienteCodigo() {
        int codigo = facturaDao.obtenerUltimoCodigo();

        return codigo;
    }
}

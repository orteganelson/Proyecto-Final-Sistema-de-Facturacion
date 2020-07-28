/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IFacturaDao;
import ec.edu.ups.modelo.Factura;
import java.util.List;

/**
 *
 * @author Juanc
 */
public class FacturaDao implements IFacturaDao{

    @Override
    public void create(Factura factura) {
        
    }

    @Override
    public Factura read(int codigo) {
        return null;
        
    }

    @Override
    public void anularFactura(Factura factura) {
       
    }

    @Override
    public List<Factura> listarTodasFacturas() {
        return null;
        
    }
    
}

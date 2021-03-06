/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Factura;
import java.util.List;

/**
 *
 * @author paul_
 */
public interface IFacturaDao {

    public void create(Factura factura);

    public Factura read(int codigo);
    
    public Factura buscarPorNumero(String numero);

    public void anularFactura(Factura factura);

    public Double obtenerSubTotal(int codigo);

    public int obtenerUltimoCodigo();

    public List<Factura> listarTodasFacturas();

}

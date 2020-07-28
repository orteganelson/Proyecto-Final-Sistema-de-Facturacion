/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Detalle;

/**
 *
 * @author Juanc
 */
public interface IDetalleDao {
    
    public void create(Detalle Detalle);

    public Detalle read(int codigo);

    
}

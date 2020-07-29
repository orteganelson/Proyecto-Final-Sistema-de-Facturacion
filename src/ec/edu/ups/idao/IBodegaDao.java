/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.idao;

import ec.edu.ups.modelo.Bodega;
import java.util.List;

/**
 *
 * @author paul_
 */
public interface IBodegaDao {

    public void create(Bodega bodega);

    public Bodega read(int codigo);

    public void update(Bodega bodega);

    public void delete(Bodega bodega);

    public int obtenerUltimoCodigo();

    public List<Bodega> listarTodasBodegas();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Alimentacion;

/**
 *
 * @author dilov
 */
@Local
public interface AlimentacionFacadeLocal {

    void create(Alimentacion alimentacion);

    void edit(Alimentacion alimentacion);

    void remove(Alimentacion alimentacion);

    Alimentacion find(Object id);

    List<Alimentacion> findAll();

    List<Alimentacion> findRange(int[] range);

    int count();
    
}

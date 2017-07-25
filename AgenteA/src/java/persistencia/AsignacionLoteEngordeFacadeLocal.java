/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.AsignacionLoteEngorde;

/**
 *
 * @author dilov
 */
@Local
public interface AsignacionLoteEngordeFacadeLocal {

    void create(AsignacionLoteEngorde asignacionLoteEngorde);

    void edit(AsignacionLoteEngorde asignacionLoteEngorde);

    void remove(AsignacionLoteEngorde asignacionLoteEngorde);

    AsignacionLoteEngorde find(Object id);

    List<AsignacionLoteEngorde> findAll();

    List<AsignacionLoteEngorde> findRange(int[] range);

    int count();
    
}

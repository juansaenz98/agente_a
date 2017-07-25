/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.AsignacionLotePonedoras;

/**
 *
 * @author dilov
 */
@Local
public interface AsignacionLotePonedorasFacadeLocal {

    void create(AsignacionLotePonedoras asignacionLotePonedoras);

    void edit(AsignacionLotePonedoras asignacionLotePonedoras);

    void remove(AsignacionLotePonedoras asignacionLotePonedoras);

    AsignacionLotePonedoras find(Object id);

    List<AsignacionLotePonedoras> findAll();

    List<AsignacionLotePonedoras> findRange(int[] range);

    int count();
    
}

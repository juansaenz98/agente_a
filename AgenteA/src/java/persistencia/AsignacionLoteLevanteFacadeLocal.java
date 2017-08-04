/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.AsignacionLoteLevante;

/**
 *
 * @author dilov
 */
@Local
public interface AsignacionLoteLevanteFacadeLocal {

    void create(AsignacionLoteLevante asignacionLoteLevante);

    void edit(AsignacionLoteLevante asignacionLoteLevante);

    void remove(AsignacionLoteLevante asignacionLoteLevante);

    AsignacionLoteLevante find(Object id);

    List<AsignacionLoteLevante> findAll();

    List<AsignacionLoteLevante> findRange(int[] range);

    int count();
    
}

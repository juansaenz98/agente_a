/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.LotePonedoras;

/**
 *
 * @author dilov
 */
@Local
public interface LotePonedorasFacadeLocal {

    void create(LotePonedoras lotePonedoras);

    void edit(LotePonedoras lotePonedoras);

    void remove(LotePonedoras lotePonedoras);

    LotePonedoras find(Object id);

    List<LotePonedoras> findAll();

    List<LotePonedoras> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.LoteLevante;

/**
 *
 * @author dilov
 */
@Local
public interface LoteLevanteFacadeLocal {

    void create(LoteLevante loteLevante);

    void edit(LoteLevante loteLevante);

    void remove(LoteLevante loteLevante);

    LoteLevante find(Object id);

    List<LoteLevante> findAll();

    List<LoteLevante> findRange(int[] range);

    int count();
    
}

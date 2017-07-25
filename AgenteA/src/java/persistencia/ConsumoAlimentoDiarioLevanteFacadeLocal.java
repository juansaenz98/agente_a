/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.ConsumoAlimentoDiarioLevante;

/**
 *
 * @author dilov
 */
@Local
public interface ConsumoAlimentoDiarioLevanteFacadeLocal {

    void create(ConsumoAlimentoDiarioLevante consumoAlimentoDiarioLevante);

    void edit(ConsumoAlimentoDiarioLevante consumoAlimentoDiarioLevante);

    void remove(ConsumoAlimentoDiarioLevante consumoAlimentoDiarioLevante);

    ConsumoAlimentoDiarioLevante find(Object id);

    List<ConsumoAlimentoDiarioLevante> findAll();

    List<ConsumoAlimentoDiarioLevante> findRange(int[] range);

    int count();
    
}

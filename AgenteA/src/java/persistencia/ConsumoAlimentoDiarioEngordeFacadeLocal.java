/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.ConsumoAlimentoDiarioEngorde;

/**
 *
 * @author dilov
 */
@Local
public interface ConsumoAlimentoDiarioEngordeFacadeLocal {

    void create(ConsumoAlimentoDiarioEngorde consumoAlimentoDiarioEngorde);

    void edit(ConsumoAlimentoDiarioEngorde consumoAlimentoDiarioEngorde);

    void remove(ConsumoAlimentoDiarioEngorde consumoAlimentoDiarioEngorde);

    ConsumoAlimentoDiarioEngorde find(Object id);

    List<ConsumoAlimentoDiarioEngorde> findAll();

    List<ConsumoAlimentoDiarioEngorde> findRange(int[] range);

    int count();
    
}

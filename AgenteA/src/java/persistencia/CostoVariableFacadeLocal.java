/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.CostoVariable;

/**
 *
 * @author dilov
 */
@Local
public interface CostoVariableFacadeLocal {

    void create(CostoVariable costoVariable);

    void edit(CostoVariable costoVariable);

    void remove(CostoVariable costoVariable);

    CostoVariable find(Object id);

    List<CostoVariable> findAll();

    List<CostoVariable> findRange(int[] range);

    int count();
    
}

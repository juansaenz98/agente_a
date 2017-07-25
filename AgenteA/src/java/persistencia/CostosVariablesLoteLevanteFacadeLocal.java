/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.CostosVariablesLoteLevante;

/**
 *
 * @author dilov
 */
@Local
public interface CostosVariablesLoteLevanteFacadeLocal {

    void create(CostosVariablesLoteLevante costosVariablesLoteLevante);

    void edit(CostosVariablesLoteLevante costosVariablesLoteLevante);

    void remove(CostosVariablesLoteLevante costosVariablesLoteLevante);

    CostosVariablesLoteLevante find(Object id);

    List<CostosVariablesLoteLevante> findAll();

    List<CostosVariablesLoteLevante> findRange(int[] range);

    int count();
    
}

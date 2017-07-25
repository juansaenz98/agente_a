/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.CostosVariablesLoteEngorde;

/**
 *
 * @author dilov
 */
@Local
public interface CostosVariablesLoteEngordeFacadeLocal {

    void create(CostosVariablesLoteEngorde costosVariablesLoteEngorde);

    void edit(CostosVariablesLoteEngorde costosVariablesLoteEngorde);

    void remove(CostosVariablesLoteEngorde costosVariablesLoteEngorde);

    CostosVariablesLoteEngorde find(Object id);

    List<CostosVariablesLoteEngorde> findAll();

    List<CostosVariablesLoteEngorde> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.LoteEngorde;

/**
 *
 * @author dilov
 */
@Local
public interface LoteEngordeFacadeLocal {

    void create(LoteEngorde loteEngorde);

    void edit(LoteEngorde loteEngorde);

    void remove(LoteEngorde loteEngorde);

    LoteEngorde find(Object id);

    List<LoteEngorde> findAll();

    List<LoteEngorde> findRange(int[] range);

    int count();
    
}

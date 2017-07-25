/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.RegistroSemanalLevante;

/**
 *
 * @author dilov
 */
@Local
public interface RegistroSemanalLevanteFacadeLocal {

    void create(RegistroSemanalLevante registroSemanalLevante);

    void edit(RegistroSemanalLevante registroSemanalLevante);

    void remove(RegistroSemanalLevante registroSemanalLevante);

    RegistroSemanalLevante find(Object id);

    List<RegistroSemanalLevante> findAll();

    List<RegistroSemanalLevante> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.RegistroSemanalPonedoras;

/**
 *
 * @author dilov
 */
@Local
public interface RegistroSemanalPonedorasFacadeLocal {

    void create(RegistroSemanalPonedoras registroSemanalPonedoras);

    void edit(RegistroSemanalPonedoras registroSemanalPonedoras);

    void remove(RegistroSemanalPonedoras registroSemanalPonedoras);

    RegistroSemanalPonedoras find(Object id);

    List<RegistroSemanalPonedoras> findAll();

    List<RegistroSemanalPonedoras> findRange(int[] range);

    int count();
    
}

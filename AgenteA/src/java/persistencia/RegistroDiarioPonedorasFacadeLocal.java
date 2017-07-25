/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.RegistroDiarioPonedoras;

/**
 *
 * @author dilov
 */
@Local
public interface RegistroDiarioPonedorasFacadeLocal {

    void create(RegistroDiarioPonedoras registroDiarioPonedoras);

    void edit(RegistroDiarioPonedoras registroDiarioPonedoras);

    void remove(RegistroDiarioPonedoras registroDiarioPonedoras);

    RegistroDiarioPonedoras find(Object id);

    List<RegistroDiarioPonedoras> findAll();

    List<RegistroDiarioPonedoras> findRange(int[] range);

    int count();
    
}

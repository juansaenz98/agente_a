/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Vacuna;

/**
 *
 * @author dilov
 */
@Local
public interface VacunaFacadeLocal {

    void create(Vacuna vacuna);

    void edit(Vacuna vacuna);

    void remove(Vacuna vacuna);

    Vacuna find(Object id);

    List<Vacuna> findAll();

    List<Vacuna> findRange(int[] range);

    int count();
    
}

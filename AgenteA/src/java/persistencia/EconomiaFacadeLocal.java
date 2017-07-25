/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Economia;

/**
 *
 * @author dilov
 */
@Local
public interface EconomiaFacadeLocal {

    void create(Economia economia);

    void edit(Economia economia);

    void remove(Economia economia);

    Economia find(Object id);

    List<Economia> findAll();

    List<Economia> findRange(int[] range);

    int count();
    
}

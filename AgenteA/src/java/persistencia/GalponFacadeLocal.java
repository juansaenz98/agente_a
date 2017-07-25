/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Galpon;

/**
 *
 * @author dilov
 */
@Local
public interface GalponFacadeLocal {

    void create(Galpon galpon);

    void edit(Galpon galpon);

    void remove(Galpon galpon);

    Galpon find(Object id);

    List<Galpon> findAll();

    List<Galpon> findRange(int[] range);

    int count();
    
}

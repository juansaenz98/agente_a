/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.Enfermedad;

/**
 *
 * @author dilov
 */
@Local
public interface EnfermedadFacadeLocal {

    void create(Enfermedad enfermedad);

    void edit(Enfermedad enfermedad);

    void remove(Enfermedad enfermedad);

    Enfermedad find(Object id);

    List<Enfermedad> findAll();

    List<Enfermedad> findRange(int[] range);

    int count();
    
}

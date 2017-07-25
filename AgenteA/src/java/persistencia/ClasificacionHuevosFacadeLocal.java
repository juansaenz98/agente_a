/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.ClasificacionHuevos;

/**
 *
 * @author dilov
 */
@Local
public interface ClasificacionHuevosFacadeLocal {

    void create(ClasificacionHuevos clasificacionHuevos);

    void edit(ClasificacionHuevos clasificacionHuevos);

    void remove(ClasificacionHuevos clasificacionHuevos);

    ClasificacionHuevos find(Object id);

    List<ClasificacionHuevos> findAll();

    List<ClasificacionHuevos> findRange(int[] range);

    int count();
    
}

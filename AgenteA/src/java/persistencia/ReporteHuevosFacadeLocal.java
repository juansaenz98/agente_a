/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.ReporteHuevos;

/**
 *
 * @author dilov
 */
@Local
public interface ReporteHuevosFacadeLocal {

    void create(ReporteHuevos reporteHuevos);

    void edit(ReporteHuevos reporteHuevos);

    void remove(ReporteHuevos reporteHuevos);

    ReporteHuevos find(Object id);

    List<ReporteHuevos> findAll();

    List<ReporteHuevos> findRange(int[] range);

    int count();
    
}

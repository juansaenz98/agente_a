/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.GuiaVacunacionLotePonedoras;

/**
 *
 * @author dilov
 */
@Local
public interface GuiaVacunacionLotePonedorasFacadeLocal {

    void create(GuiaVacunacionLotePonedoras guiaVacunacionLotePonedoras);

    void edit(GuiaVacunacionLotePonedoras guiaVacunacionLotePonedoras);

    void remove(GuiaVacunacionLotePonedoras guiaVacunacionLotePonedoras);

    GuiaVacunacionLotePonedoras find(Object id);

    List<GuiaVacunacionLotePonedoras> findAll();

    List<GuiaVacunacionLotePonedoras> findRange(int[] range);

    int count();
    
}

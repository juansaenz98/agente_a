/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.GuiaVacunacionLoteLevante;

/**
 *
 * @author dilov
 */
@Local
public interface GuiaVacunacionLoteLevanteFacadeLocal {

    void create(GuiaVacunacionLoteLevante guiaVacunacionLoteLevante);

    void edit(GuiaVacunacionLoteLevante guiaVacunacionLoteLevante);

    void remove(GuiaVacunacionLoteLevante guiaVacunacionLoteLevante);

    GuiaVacunacionLoteLevante find(Object id);

    List<GuiaVacunacionLoteLevante> findAll();

    List<GuiaVacunacionLoteLevante> findRange(int[] range);

    int count();
    
}

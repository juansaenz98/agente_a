/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.GuiaVacunacionLoteEngorde;

/**
 *
 * @author dilov
 */
@Local
public interface GuiaVacunacionLoteEngordeFacadeLocal {

    void create(GuiaVacunacionLoteEngorde guiaVacunacionLoteEngorde);

    void edit(GuiaVacunacionLoteEngorde guiaVacunacionLoteEngorde);

    void remove(GuiaVacunacionLoteEngorde guiaVacunacionLoteEngorde);

    GuiaVacunacionLoteEngorde find(Object id);

    List<GuiaVacunacionLoteEngorde> findAll();

    List<GuiaVacunacionLoteEngorde> findRange(int[] range);

    int count();
    
}

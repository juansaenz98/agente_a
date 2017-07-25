/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.BajasMuertesDiarioEngorde;

/**
 *
 * @author dilov
 */
@Local
public interface BajasMuertesDiarioEngordeFacadeLocal {

    void create(BajasMuertesDiarioEngorde bajasMuertesDiarioEngorde);

    void edit(BajasMuertesDiarioEngorde bajasMuertesDiarioEngorde);

    void remove(BajasMuertesDiarioEngorde bajasMuertesDiarioEngorde);

    BajasMuertesDiarioEngorde find(Object id);

    List<BajasMuertesDiarioEngorde> findAll();

    List<BajasMuertesDiarioEngorde> findRange(int[] range);

    int count();
    
}

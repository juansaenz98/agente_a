/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.BajasMuertesDiarioLevante;

/**
 *
 * @author dilov
 */
@Local
public interface BajasMuertesDiarioLevanteFacadeLocal {

    void create(BajasMuertesDiarioLevante bajasMuertesDiarioLevante);

    void edit(BajasMuertesDiarioLevante bajasMuertesDiarioLevante);

    void remove(BajasMuertesDiarioLevante bajasMuertesDiarioLevante);

    BajasMuertesDiarioLevante find(Object id);

    List<BajasMuertesDiarioLevante> findAll();

    List<BajasMuertesDiarioLevante> findRange(int[] range);

    int count();
    
}

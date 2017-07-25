/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.VitaminasEngorde;

/**
 *
 * @author dilov
 */
@Local
public interface VitaminasEngordeFacadeLocal {

    void create(VitaminasEngorde vitaminasEngorde);

    void edit(VitaminasEngorde vitaminasEngorde);

    void remove(VitaminasEngorde vitaminasEngorde);

    VitaminasEngorde find(Object id);

    List<VitaminasEngorde> findAll();

    List<VitaminasEngorde> findRange(int[] range);

    int count();
    
}

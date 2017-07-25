/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.SacrifioVentaEngorde;

/**
 *
 * @author dilov
 */
@Local
public interface SacrifioVentaEngordeFacadeLocal {

    void create(SacrifioVentaEngorde sacrifioVentaEngorde);

    void edit(SacrifioVentaEngorde sacrifioVentaEngorde);

    void remove(SacrifioVentaEngorde sacrifioVentaEngorde);

    SacrifioVentaEngorde find(Object id);

    List<SacrifioVentaEngorde> findAll();

    List<SacrifioVentaEngorde> findRange(int[] range);

    int count();
    
}

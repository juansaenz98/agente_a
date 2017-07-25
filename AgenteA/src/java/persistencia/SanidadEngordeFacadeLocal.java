/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.SanidadEngorde;

/**
 *
 * @author dilov
 */
@Local
public interface SanidadEngordeFacadeLocal {

    void create(SanidadEngorde sanidadEngorde);

    void edit(SanidadEngorde sanidadEngorde);

    void remove(SanidadEngorde sanidadEngorde);

    SanidadEngorde find(Object id);

    List<SanidadEngorde> findAll();

    List<SanidadEngorde> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.TipoAlimento;

/**
 *
 * @author dilov
 */
@Local
public interface TipoAlimentoFacadeLocal {

    void create(TipoAlimento tipoAlimento);

    void edit(TipoAlimento tipoAlimento);

    void remove(TipoAlimento tipoAlimento);

    TipoAlimento find(Object id);

    List<TipoAlimento> findAll();

    List<TipoAlimento> findRange(int[] range);

    int count();
    
}

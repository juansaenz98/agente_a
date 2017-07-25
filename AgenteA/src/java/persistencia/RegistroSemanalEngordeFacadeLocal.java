/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;
import modelo.RegistroSemanalEngorde;

/**
 *
 * @author dilov
 */
@Local
public interface RegistroSemanalEngordeFacadeLocal {

    void create(RegistroSemanalEngorde registroSemanalEngorde);

    void edit(RegistroSemanalEngorde registroSemanalEngorde);

    void remove(RegistroSemanalEngorde registroSemanalEngorde);

    RegistroSemanalEngorde find(Object id);

    List<RegistroSemanalEngorde> findAll();

    List<RegistroSemanalEngorde> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Economia;

/**
 *
 * @author dilov
 */
@Stateless
public class EconomiaFacade extends AbstractFacade<Economia> implements EconomiaFacadeLocal {
    @PersistenceContext(unitName = "AgenteAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EconomiaFacade() {
        super(Economia.class);
    }
    
}

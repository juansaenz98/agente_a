/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.RegistroSemanalPonedoras;

/**
 *
 * @author dilov
 */
@Stateless
public class RegistroSemanalPonedorasFacade extends AbstractFacade<RegistroSemanalPonedoras> implements RegistroSemanalPonedorasFacadeLocal {
    @PersistenceContext(unitName = "AgenteAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroSemanalPonedorasFacade() {
        super(RegistroSemanalPonedoras.class);
    }
    
}

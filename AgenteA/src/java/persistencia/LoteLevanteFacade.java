/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.LoteLevante;

/**
 *
 * @author dilov
 */
@Stateless
public class LoteLevanteFacade extends AbstractFacade<LoteLevante> implements LoteLevanteFacadeLocal {
    @PersistenceContext(unitName = "AgenteAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoteLevanteFacade() {
        super(LoteLevante.class);
    }
    
}

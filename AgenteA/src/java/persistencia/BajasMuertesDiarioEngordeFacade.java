/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.BajasMuertesDiarioEngorde;

/**
 *
 * @author dilov
 */
@Stateless
public class BajasMuertesDiarioEngordeFacade extends AbstractFacade<BajasMuertesDiarioEngorde> implements BajasMuertesDiarioEngordeFacadeLocal {
    @PersistenceContext(unitName = "AgenteAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BajasMuertesDiarioEngordeFacade() {
        super(BajasMuertesDiarioEngorde.class);
    }
    
}

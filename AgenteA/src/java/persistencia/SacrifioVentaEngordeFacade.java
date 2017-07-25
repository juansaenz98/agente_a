/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.SacrifioVentaEngorde;

/**
 *
 * @author dilov
 */
@Stateless
public class SacrifioVentaEngordeFacade extends AbstractFacade<SacrifioVentaEngorde> implements SacrifioVentaEngordeFacadeLocal {
    @PersistenceContext(unitName = "AgenteAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SacrifioVentaEngordeFacade() {
        super(SacrifioVentaEngorde.class);
    }
    
}

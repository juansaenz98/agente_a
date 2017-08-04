/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.AsignacionLoteLevante;

/**
 *
 * @author dilov
 */
@Stateless
public class AsignacionLoteLevanteFacade extends AbstractFacade<AsignacionLoteLevante> implements AsignacionLoteLevanteFacadeLocal {
    @PersistenceContext(unitName = "AgenteAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacionLoteLevanteFacade() {
        super(AsignacionLoteLevante.class);
    }
    
}

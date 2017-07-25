/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.GuiaVacunacionLoteLevante;

/**
 *
 * @author dilov
 */
@Stateless
public class GuiaVacunacionLoteLevanteFacade extends AbstractFacade<GuiaVacunacionLoteLevante> implements GuiaVacunacionLoteLevanteFacadeLocal {
    @PersistenceContext(unitName = "AgenteAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuiaVacunacionLoteLevanteFacade() {
        super(GuiaVacunacionLoteLevante.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.GuiaVacunacionLotePonedoras;

/**
 *
 * @author dilov
 */
@Stateless
public class GuiaVacunacionLotePonedorasFacade extends AbstractFacade<GuiaVacunacionLotePonedoras> implements GuiaVacunacionLotePonedorasFacadeLocal {
    @PersistenceContext(unitName = "AgenteAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GuiaVacunacionLotePonedorasFacade() {
        super(GuiaVacunacionLotePonedoras.class);
    }
    
}

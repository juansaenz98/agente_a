/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.ReporteHuevos;

/**
 *
 * @author dilov
 */
@Stateless
public class ReporteHuevosFacade extends AbstractFacade<ReporteHuevos> implements ReporteHuevosFacadeLocal {
    @PersistenceContext(unitName = "AgenteAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteHuevosFacade() {
        super(ReporteHuevos.class);
    }
    
}

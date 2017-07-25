/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.TipoAlimento;

/**
 *
 * @author dilov
 */
@Stateless
public class TipoAlimentoFacade extends AbstractFacade<TipoAlimento> implements TipoAlimentoFacadeLocal {
    @PersistenceContext(unitName = "AgenteAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoAlimentoFacade() {
        super(TipoAlimento.class);
    }
    
}

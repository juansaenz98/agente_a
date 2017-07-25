/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.CostosVariablesLoteEngorde;

/**
 *
 * @author dilov
 */
@Stateless
public class CostosVariablesLoteEngordeFacade extends AbstractFacade<CostosVariablesLoteEngorde> implements CostosVariablesLoteEngordeFacadeLocal {
    @PersistenceContext(unitName = "AgenteAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CostosVariablesLoteEngordeFacade() {
        super(CostosVariablesLoteEngorde.class);
    }
    
}

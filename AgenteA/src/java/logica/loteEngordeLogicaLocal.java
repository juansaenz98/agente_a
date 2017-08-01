/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.Local;
import modelo.LoteEngorde;

/**
 *
 * @author Diana Vanesa
 */
@Local
public interface loteEngordeLogicaLocal {
    public List<LoteEngorde> consultarLotesEngorde() throws Exception;
    
    public LoteEngorde consultarLoteEngorde(LoteEngorde objLote) throws Exception;
    
    public void registrarLoteEngorde (LoteEngorde objLote) throws Exception;
    
    public void modificarLoteEngorde(LoteEngorde objLote) throws Exception;
}

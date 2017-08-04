/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Galpon;
import modelo.LoteEngorde;
import modelo.Raza;
import persistencia.GalponFacadeLocal;
import persistencia.LoteEngordeFacadeLocal;
import persistencia.RazaFacadeLocal;

/**
 *
 * @author Diana Vanesa
 */
@Stateless
public class loteEngordeLogica implements loteEngordeLogicaLocal {
    @EJB
    LoteEngordeFacadeLocal loteEngordeDAO;
    @EJB
    GalponFacadeLocal galponDAO;
    @EJB
    RazaFacadeLocal razaDAO;
    
    
    @Override
    public List<LoteEngorde> consultarLotesEngorde() throws Exception {
        return loteEngordeDAO.findAll();
    }

    @Override
    public LoteEngorde consultarLoteEngorde(LoteEngorde objLote) throws Exception {
        return loteEngordeDAO.find(objLote);
        
    }

    @Override
    public void registrarLoteEngorde(LoteEngorde objLote) throws Exception {
        if (objLote == null) {
            throw new Exception("todos lso campos son obligatorios, no se puede realizar el registro");
        }
        if (objLote.getNumeroGalponFk()== null) {
            throw new Exception("debe de elegir un galpón, no se puede realizar el registro");
        }
        if (objLote.getCodigoRazaFk()==null) {
            throw new Exception("debe de elegir una raza, no se puede realizar el registro");
        }
        Galpon objGalpon = galponDAO.find(objLote.getNumeroGalponFk().getNumeroGalpon());
        if (objGalpon == null) {
            throw new Exception("el galpón elegido no esta registrado, no se puede realizar el registro");
        }
        Raza objRaza = razaDAO.find(objLote.getCodigoRazaFk().getCodigoRaza());
        if (objRaza == null) {
            throw new Exception("la raza elegida no esta registrada, no se puede realizar el registro");
        }
        loteEngordeDAO.create(objLote);
        
    }

    @Override
    public void modificarLoteEngorde(LoteEngorde objLote) throws Exception {
        if (objLote == null) {
            throw new Exception("todos lso campos son obligatorios, no se puede realizar la modificación");
        }
        if (objLote.getNumeroGalponFk()== null) {
            throw new Exception("debe de elegir un galpón, no se puede realizar la modificación");
        }
        if (objLote.getCodigoRazaFk()==null) {
            throw new Exception("debe de elegir una raza, no se puede realizar la modificación");
        }
        Galpon objGalpon = galponDAO.find(objLote.getNumeroGalponFk().getNumeroGalpon());
        if (objGalpon == null) {
            throw new Exception("el galpón elegido no esta registrado, no se puede realizar la modificación");
        }
        Raza objRaza = razaDAO.find(objLote.getCodigoRazaFk().getCodigoRaza());
        if (objRaza == null) {
            throw new Exception("la raza elegida no esta registrada, no se puede realizar la modificación");
        }
        loteEngordeDAO.edit(objLote);
    }

}

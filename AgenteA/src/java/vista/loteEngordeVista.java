/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import logica.loteEngordeLogicaLocal;
import modelo.Galpon;
import modelo.LoteEngorde;
import modelo.Raza;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import persistencia.GalponFacadeLocal;
import persistencia.RazaFacadeLocal;

/**
 *
 * @author Diana Vanesa
 */
@ManagedBean
@RequestScoped
public class loteEngordeVista {

    /**
     * Creates a new instance of loteEngordeVista
     */
    public loteEngordeVista() {
    }
    @EJB
    loteEngordeLogicaLocal loteEnogordeLogica;
    @EJB
    GalponFacadeLocal galponDAO;
    @EJB
    RazaFacadeLocal razaDAO;
    
    public InputText txtCodigo;
    public SelectOneMenu comboGalpon;
    public SelectOneMenu comboRaza;
    public Calendar txtFecha;
    public InputText txtDensidad;
    public InputText txtNumeroInicial;
    public InputText txtPesoInicial;
    public InputText txtTotalPesoPromedio;
    public InputText txtNumeroFinal;
    public InputText txtTotalCanal;
    public InputText txtPesoCanal;
    public InputText txtTotalVivo;
    public InputText txtPesoVivo;
    
    public Galpon objGalpon;
    public Raza objRaza;
    public LoteEngorde objLoteSeleccionado;
    
    public List<Galpon> listaGalpon;
    public ArrayList<SelectItem> itemsGalpon;
    public List<Raza> listaRaza;
    public ArrayList<SelectItem> itemsRaza;
    public List<LoteEngorde> listaLoteEngorde;
    
    public CommandButton btnRegistrar;
    public CommandButton btnModificar;
    public CommandButton btnLimpiar;

    public InputText getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(InputText txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public SelectOneMenu getComboGalpon() {
        return comboGalpon;
    }

    public void setComboGalpon(SelectOneMenu comboGalpon) {
        this.comboGalpon = comboGalpon;
    }

    public SelectOneMenu getComboRaza() {
        return comboRaza;
    }

    public void setComboRaza(SelectOneMenu comboRaza) {
        this.comboRaza = comboRaza;
    }

    public Calendar getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(Calendar txtFecha) {
        this.txtFecha = txtFecha;
    }

    public InputText getTxtDensidad() {
        return txtDensidad;
    }

    public void setTxtDensidad(InputText txtDensidad) {
        this.txtDensidad = txtDensidad;
    }

    public InputText getTxtNumeroInicial() {
        return txtNumeroInicial;
    }

    public void setTxtNumeroInicial(InputText txtNumeroInicial) {
        this.txtNumeroInicial = txtNumeroInicial;
    }

    public InputText getTxtPesoInicial() {
        return txtPesoInicial;
    }

    public void setTxtPesoInicial(InputText txtPesoInicial) {
        this.txtPesoInicial = txtPesoInicial;
    }

    public InputText getTxtTotalPesoPromedio() {
        return txtTotalPesoPromedio;
    }

    public void setTxtTotalPesoPromedio(InputText txtTotalPesoPromedio) {
        this.txtTotalPesoPromedio = txtTotalPesoPromedio;
    }

    public InputText getTxtNumeroFinal() {
        return txtNumeroFinal;
    }

    public void setTxtNumeroFinal(InputText txtNumeroFinal) {
        this.txtNumeroFinal = txtNumeroFinal;
    }

    public InputText getTxtTotalCanal() {
        return txtTotalCanal;
    }

    public void setTxtTotalCanal(InputText txtTotalCanal) {
        this.txtTotalCanal = txtTotalCanal;
    }

    public InputText getTxtPesoCanal() {
        return txtPesoCanal;
    }

    public void setTxtPesoCanal(InputText txtPesoCanal) {
        this.txtPesoCanal = txtPesoCanal;
    }

    public InputText getTxtTotalVivo() {
        return txtTotalVivo;
    }

    public void setTxtTotalVivo(InputText txtTotalVivo) {
        this.txtTotalVivo = txtTotalVivo;
    }

    public InputText getTxtPesoVivo() {
        return txtPesoVivo;
    }

    public void setTxtPesoVivo(InputText txtPesoVivo) {
        this.txtPesoVivo = txtPesoVivo;
    }

    public Galpon getObjGalpon() {
        return objGalpon;
    }

    public void setObjGalpon(Galpon objGalpon) {
        this.objGalpon = objGalpon;
    }

    public Raza getObjRaza() {
        return objRaza;
    }

    public void setObjRaza(Raza objRaza) {
        this.objRaza = objRaza;
    }

    public LoteEngorde getObjLoteSeleccionado() {
        return objLoteSeleccionado;
    }

    public void setObjLoteSeleccionado(LoteEngorde objLoteSeleccionado) {
        this.objLoteSeleccionado = objLoteSeleccionado;
    }

    public List<Galpon> getListaGalpon() {
        return listaGalpon;
    }

    public void setListaGalpon(List<Galpon> listaGalpon) {
        this.listaGalpon = listaGalpon;
    }

    public ArrayList<SelectItem> getItemsGalpon() {
        listaGalpon = galponDAO.findAll();
        itemsGalpon = new ArrayList<>();
        for(Galpon g : listaGalpon) {
            itemsGalpon.add(new SelectItem(g.getNumeroGalpon(), g.getNumeroGalpon().toString()));
        }
        return itemsGalpon;
    }

    public void setItemsGalpon(ArrayList<SelectItem> itemsGalpon) {
        this.itemsGalpon = itemsGalpon;
    }

    public List<Raza> getListaRaza() {
        return listaRaza;
    }

    public void setListaRaza(List<Raza> listaRaza) {
        this.listaRaza = listaRaza;
    }

    public ArrayList<SelectItem> getItemsRaza() {
        listaRaza = razaDAO.findAll();
        itemsRaza = new ArrayList<>();
        for(Raza r: listaRaza) {
            itemsRaza.add(new SelectItem(r.getCodigoRaza(), r.getNombreRaza()));
        }
        return itemsRaza;
    }

    public void setItemsRaza(ArrayList<SelectItem> itemsRaza) {
        this.itemsRaza = itemsRaza;
    }

    public List<LoteEngorde> getListaLoteEngorde() {
        try {
            listaLoteEngorde = loteEnogordeLogica.consultarLotesEngorde();
        } catch (Exception ex) {
            Logger.getLogger(loteEngordeVista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaLoteEngorde;
    }

    public void setListaLoteEngorde(List<LoteEngorde> listaLoteEngorde) {
        this.listaLoteEngorde = listaLoteEngorde;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }
    
    public void registrar() {
        
    }
    
    public void modificar() {
        
    }
    
    public void limpiar() {
        
    }
}

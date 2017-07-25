/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author jhon
 */
@Named(value = "registroSemanalLevanteVista")
@RequestScoped
public class RegistroSemanalLevanteVista {

    private Date semanaDeRegistro;
    private Date semanaARegistro;

    public Date getSemanaARegistro() {
        return semanaARegistro;
    }

    public void setSemanaARegistro(Date semanaARegistro) {
        this.semanaARegistro = semanaARegistro;
    }
    
    
    public Date getSemanaDeRegistro() {
        return semanaDeRegistro;
    }

    public void setSemanaDeRegistro(Date semanaDeRegistro) {
        this.semanaDeRegistro = semanaDeRegistro;
    }
    
    /**
     * Creates a new instance of RegistroSemanalLevanteVista
     */
    public RegistroSemanalLevanteVista() {
    }
    
}

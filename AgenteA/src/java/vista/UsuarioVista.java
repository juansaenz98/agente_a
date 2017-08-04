/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import logica.UsuarioLogicaLocal;
import modelo.Usuario;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author dilov
 */
@Named(value = "usuarioVista")
@RequestScoped
public class UsuarioVista {
    @EJB
    private UsuarioLogicaLocal usuarioLogica;
    
    private InputText txtDocumento;
    private Password txtClave;
    private CommandButton btnIngresar;  
    

    /**
     * Creates a new instance of UsuarioVista
     */
    public UsuarioVista() {
    }

    public InputText getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(InputText txtDocumento) {
        this.txtDocumento = txtDocumento;
    }

    public Password getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(Password txtClave) {
        this.txtClave = txtClave;
    }

    public CommandButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(CommandButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }
    
    public void ingresar(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            ExternalContext extContext = context.getExternalContext();
            String url = "";
            Long documento = Long.parseLong(txtDocumento.getValue().toString());
            String clave = txtClave.getValue().toString();
            Usuario usrLogueado = usuarioLogica.ingresar_usuario(documento,clave);
            if(usrLogueado.getTipoUsuario().equals("administrador")){
                //Administrador
                url = extContext.encodeActionURL(context.getApplication()
                        .getViewHandler().getActionURL(context, "/indexAdministrador.xhtml"));
            }else if(usrLogueado.getTipoUsuario().equals("instructor")){
                //Instructor
                url = extContext.encodeActionURL(context.getApplication()
                        .getViewHandler().getActionURL(context, "/indexInstructor.xhtml"));
            }else{
                //Aprediz
                url = extContext.encodeActionURL(context.getApplication()
                        .getViewHandler().getActionURL(context, "/indexAprendiz.xhtml"));
            }
            extContext.getSessionMap().put("datos", usrLogueado);
            extContext.redirect(url);
        }catch(NumberFormatException e){
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","El documento debe ser numérico"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",ex.getMessage()));
        }
        
        
    }
    
}

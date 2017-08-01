/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Usuario;
import persistencia.UsuarioFacadeLocal;

/**
 *
 * @author dilov
 */
@Stateless
public class UsuarioLogica implements UsuarioLogicaLocal {
    @EJB
    private UsuarioFacadeLocal usuarioDAO;

    @Override
    public Usuario ingresar_usuario(Long documento, String clave) throws Exception {
        if(documento==null){
            throw new Exception("El documento es obligatorio");
        }
        if(clave==null || clave.equals("")){
            throw new Exception("La clave es Obligatoria");
        }
        Usuario objU = usuarioDAO.findxDocumento(documento);
        if(objU == null){
            throw new Exception("Usuario no está registrado");
        }else{
            if(!objU.getClaveUsuario().equals(clave)){
                throw new Exception("Clave incorrecta");
            }
        }
        return objU;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

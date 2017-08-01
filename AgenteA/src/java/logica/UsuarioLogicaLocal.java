/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import javax.ejb.Local;
import modelo.Usuario;

/**
 *
 * @author dilov
 */
@Local
public interface UsuarioLogicaLocal {
    public Usuario ingresar_usuario(Long documento, String clave) throws Exception;
}

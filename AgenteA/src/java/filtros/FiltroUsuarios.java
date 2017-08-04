/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author dilov
 */
public class FiltroUsuarios implements Filter{
    private FilterConfig configuracion;
    List<String> paginasAdmin = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.configuracion = filterConfig;
        paginasAdmin.add("lotePonedoras.xhtml");
        paginasAdmin.add("consultaPonedoras.xhtml");
    }  
    

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Usuario usrLogueado = (Usuario) ((HttpServletRequest) request)
                .getSession().getAttribute("datos");
        String paginaRequest = ((HttpServletRequest) request).getRequestURI();
        if(usrLogueado == null){
            //No hay sesion activa
            ((HttpServletResponse) response).sendRedirect("index.xhtml");
        }else{
            //Validar si tiene los permisos
            if(usrLogueado.getTipoUsuario().equals("administrador")
                    && paginaRequest.contains("indexAdministrador")){
                chain.doFilter(request, response);
            }else if(usrLogueado.getTipoUsuario().equals("aprendiz")
                    && paginaRequest.contains("indexAprendiz")){
                chain.doFilter(request, response);
            }else if(usrLogueado.getTipoUsuario().equals("instructor")
                    && paginaRequest.contains("indexInstructor")){
                chain.doFilter(request, response);
            }else{
                ((HttpServletResponse) response).sendRedirect("index.xhtml");
            }
            
        }   
    }

    @Override
    public void destroy() {
        this.configuracion = null;
    }
    
    public boolean buscar(String pagina){
        return false;
    }
        
}

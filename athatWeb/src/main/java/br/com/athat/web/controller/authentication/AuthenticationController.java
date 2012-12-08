package br.com.athat.web.controller.authentication;

import br.com.athat.web.config.Navigation;
import br.com.athat.core.entity.usuario.Usuario;
import br.com.athat.web.utils.AbstractController;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationController extends AbstractController {

    private static final long serialVersionUID = 1L;

    public String exit() {
        try {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            final ServletRequest request = (ServletRequest) context.getRequest();
            final ServletResponse response = (ServletResponse) context.getResponse();
            request.getRequestDispatcher("/j_spring_security_logout").forward(request, response);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Navigation.login.name();
    }

    public void access() {
        try {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            final ServletRequest request = (ServletRequest) context.getRequest();
            final ServletResponse response = (ServletResponse) context.getResponse();
            request.getRequestDispatcher("/j_spring_security_check").forward(request, response);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
           e.printStackTrace();
           setMessage("Não foi possível fazer o login." + e.getMessage());
        }
    }

   public String getUserSession() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
   }

   public Usuario getUsuario(){
        return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}

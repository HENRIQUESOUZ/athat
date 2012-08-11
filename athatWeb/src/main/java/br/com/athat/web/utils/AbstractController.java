package br.com.athat.web.utils;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

public class AbstractController implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public static final String USUARIO_SESSION = "USUARIO_SESSION";

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected void setMessage(String message) {
        setMessage(null, message);
    }

    protected void setMessageGrowl(Severity severity, String message) {
        setMessage(severity, null, message);
    }

    protected void setMessage(Severity severity, String clientId, String message) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(severity, message, message));
    }

    protected void setMessage(String clientId, String message) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(message));
    }

    public void putSession(String key, Object object) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, object);
    }

    public Object getSession(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
    }

    public void removeSession(String key) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(key);
    }

    public void clearSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
    }

    @SuppressWarnings("unchecked")
    public <T> T getPrincipal(Class<T> klazz) {
        return (T)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    
    protected void getMessageCadastroSucesso() {
        setMessage(FacesMessage.SEVERITY_INFO, null, "Cadastro Salvo com Sucesso.");
    }

     protected void getMessageInstabilidade() {
        setMessage(FacesMessage.SEVERITY_WARN, null, "Instabilidades ao Salvar.");
    }
     
     protected String getParametro(String parametro){
    	 return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(parametro);
     }
}

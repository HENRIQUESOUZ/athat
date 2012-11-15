package br.com.athat.web.config;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

public class LoginErrorPhaseListener implements PhaseListener {

    private static final long serialVersionUID = 1L;

     @Override
    public void afterPhase(PhaseEvent event) {

    }

    @Override
    public void beforePhase(PhaseEvent event) {
        final Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        Exception dadosIncorretosException = (Exception)sessionMap.get(WebAttributes.AUTHENTICATION_EXCEPTION);
        if (dadosIncorretosException instanceof BadCredentialsException) {
            sessionMap.put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
            if (dadosIncorretosException.getMessage().toLowerCase().equals("bad credentials"))	{
            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário ou senha incorreto."));
            } else {
            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(((BadCredentialsException)dadosIncorretosException).getMessage()));
            }
        }

        if (dadosIncorretosException instanceof SessionAuthenticationException) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(dadosIncorretosException.getMessage()));
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
}

package br.com.athat.web.controller.authentication;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;

import br.com.athat.core.entity.usuario.PermissaoUsuarioType;
import br.com.athat.core.entity.usuario.Usuario;

import com.google.common.base.Strings;

public class Voter implements AccessDecisionVoter<FilterInvocation> {
	
	public boolean supports(ConfigAttribute ca) {
        return true;
    }

    public boolean supports(Class<?> type) {
        return FilterInvocation.class.isAssignableFrom(type);
    }

    public int vote(Authentication a, FilterInvocation s, Collection<ConfigAttribute> clctn) {
        final String uri = extractUri(s);
        if ("/pages/principal.jsf".equals(uri)) 
            return ACCESS_GRANTED;
        
        PermissaoUsuarioType permissao = PermissaoUsuarioType.fromUri(uri);
        Usuario usuario = (Usuario) a.getPrincipal();
        return ACCESS_DENIED;
    }
    
    private String extractUri(FilterInvocation invocation) {
        HttpServletRequest httpRequest = invocation.getHttpRequest();
        if (Strings.isNullOrEmpty(httpRequest.getPathInfo())) 
            return httpRequest.getServletPath();
        
        return String.format("%s%s", httpRequest.getServletPath(), httpRequest.getPathInfo());
    }

}

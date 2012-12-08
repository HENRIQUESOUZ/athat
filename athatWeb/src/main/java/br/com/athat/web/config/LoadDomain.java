package br.com.athat.web.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.athat.core.entity.usuario.Usuario;
import br.com.athat.core.manager.usuario.UsuarioManager;

public class LoadDomain implements Filter {

    private UsuarioManager usuarioManager;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
        usuarioManager = (UsuarioManager) context.getBean("usuarioManager");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final String login = request.getParameter("f");

        Usuario usuario = usuarioManager.findByLogin(login);
            if (login == null) {
                ((HttpServletRequest)request).getSession().invalidate();
            } else {
              ((HttpServletRequest)request).getSession().setAttribute("usuario", usuario);
            }
            chain.doFilter(request, response);
        
    }

    public void destroy() {}

}

package br.com.athat.web.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.com.athat.core.manager.usuario.UsuarioManager;


public class FirstTimeLoginContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(event.getServletContext());

        UsuarioManager usuarioManager = (UsuarioManager) context.getBean("usuarioManager");

        usuarioManager.createAdmin();
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

}

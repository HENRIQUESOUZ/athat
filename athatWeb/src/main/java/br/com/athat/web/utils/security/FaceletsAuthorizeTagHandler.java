package br.com.athat.web.utils.security;

import java.io.IOException;
import javax.faces.component.UIComponent;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagConfig;
import javax.faces.view.facelets.TagHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import br.com.athat.core.entity.usuario.PermissaoUsuarioType;
import br.com.athat.core.entity.usuario.Usuario;

public class FaceletsAuthorizeTagHandler  extends TagHandler {

    private final String access;
    
    public FaceletsAuthorizeTagHandler(TagConfig config) {
        super(config);
        this.access = this.getAttribute("access").getValue();
    }
    
    @Override
    public void apply(FaceletContext ctx, UIComponent parent) throws IOException {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (usuario == null) {
            return;
        }
        PermissaoUsuarioType permissao = PermissaoUsuarioType.valueOf(access);
        if (usuario.getAutorizacoes().contains(permissao) && !usuario.getNegacoes().contains(permissao)) {
            this.nextHandler.apply(ctx, parent);
        }
    }
}

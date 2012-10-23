package br.com.athat.core.manager.usuario;

import br.com.athat.core.entity.usuario.Usuario;

public interface UsuarioManager {
    
    public Usuario findByLogin(String login);

    public void createAdmin();
    
    public void salvar(Usuario usuario);
    
}

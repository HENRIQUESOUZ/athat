package br.com.athat.core.usuario.manager;

import br.com.athat.core.usuario.entity.Usuario;

public interface UsuarioManager {
    
    public Usuario findByLogin(String login);

    public void createAdmin();
    
    public void salvar(Usuario usuario);
    
}

package br.com.athat.core.manager.usuario;

import java.util.List;

import br.com.athat.core.entity.usuario.Usuario;
import br.com.athat.core.manager.AbstractManager;

public interface UsuarioManager extends AbstractManager {
    
    public Usuario findByLogin(String login);

    public void createAdmin();
    
    public void salvar(Usuario usuario);
    
    public Usuario login(String nome, String senha);
    
    public List<Usuario> buscar(String nome);
    
}

package br.com.athat.core.usuario.builder;

import java.io.Serializable;

import br.com.athat.core.usuario.entity.Perfil;
import br.com.athat.core.usuario.entity.Usuario;

public class UsuarioBuilder implements Serializable{
    
   private static final long serialVersionUID = 1L;
	
    public void build(Usuario usuario){
        
        Perfil perfilAdmin = new Perfil();
        perfilAdmin.setDescricao("Admin");
        
        //usuarioManager.salvar(usuario,perfilAdmin);       
    }
    
}

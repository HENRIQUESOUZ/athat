package br.com.athat.web.controller.usuario;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.usuario.Usuario;
import br.com.athat.core.manager.usuario.UsuarioManager;
import br.com.athat.web.utils.AbstractController;

public class UsuarioController extends AbstractController{
    
	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private List<Usuario> usuarios;
	private String nome;
    
    @Autowired
    private UsuarioManager usuarioManager;
    
    public UsuarioController() {
    	init();
    }
    
    @PostConstruct
    public void edit() {
    	String id = getParametro("id");
		if (id != null) {
        	usuario = usuarioManager.buscarPorId(Usuario.class, Long.valueOf(id));
		}
    }

    public String salvar(){
      try {  
    	  usuarioManager.salvar(usuario);
          getMessageCadastroSucesso();
            
      }catch(Exception e){
          getMessageInstabilidade();
      }
        return "/pages/cadastro/listagemUsuario";
    }
    
    public String logout() {
    	init();
    	return "/login";
    }
    
    public void buscar() {
    	usuarios = usuarioManager.buscar(nome);
    }
    
    private void init() {
    	usuario = new Usuario();
    	usuarios = new ArrayList<Usuario>();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public List<Usuario> getUsuarios() {
		return usuarios;
	}
    
    public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
    
    public String getNome() {
		return nome;
	}
    
    public void setNome(String nome) {
		this.nome = nome;
	}
    
}

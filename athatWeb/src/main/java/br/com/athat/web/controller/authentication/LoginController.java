package br.com.athat.web.controller.authentication;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.usuario.Usuario;
import br.com.athat.core.manager.usuario.UsuarioManager;
import br.com.athat.web.utils.AbstractController;

public class LoginController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	private String nome;
	private String senha;
	
	@Autowired
	private UsuarioManager usuarioManager;
	
	public LoginController() {
		init();
	}
	
	public String login() {
		usuario = usuarioManager.login(nome, senha);
		if(usuario != null && usuario.getId() != null) {
			return "/pages/principal?faces-redirect=true";
		} else {
			setMessage("Usuário ou senha inválido");
			return "/login";
		}
	}
	
	private void init() {
		usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

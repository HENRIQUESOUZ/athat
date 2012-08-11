package br.com.athat.core.usuario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

import br.com.athat.core.entity.AbstractEntity;

@Entity
public class Perfil extends AbstractEntity implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 21, nullable = false, unique = true)
	private String descricao;

	public String getAuthority() {
		return this.descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

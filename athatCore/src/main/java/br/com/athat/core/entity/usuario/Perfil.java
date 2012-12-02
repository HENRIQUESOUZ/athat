package br.com.athat.core.entity.usuario;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.springframework.security.core.GrantedAuthority;

import br.com.athat.core.entity.AbstractEntity;

@Entity
public class Perfil extends AbstractEntity implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	@Column(length = 21, nullable = false, unique = true)
	private String descricao;
	
	
	@Enumerated(EnumType.STRING)
    private PerfilType perfilType;
    
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass=PermissaoUsuarioType.class)
    private List<PermissaoUsuarioType> permissoes;


	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public PerfilType getPerfilType() {
		return perfilType;
	}

	public void setPerfilType(PerfilType perfilType) {
		this.perfilType = perfilType;
	}

	public List<PermissaoUsuarioType> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<PermissaoUsuarioType> permissoes) {
		this.permissoes = permissoes;
	}

	@Override
	public String getAuthority() {
		return this.descricao;
	}

}

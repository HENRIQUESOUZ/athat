package br.com.athat.core.usuario.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.athat.core.entity.AbstractEntity;

@Entity
public class UsuarioPerfil extends AbstractEntity {
    
	private static final long serialVersionUID = 1L;

	@JoinColumn(name = "usuario_fk", nullable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "perfil_fk", nullable = false)
    private Perfil perfil;

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

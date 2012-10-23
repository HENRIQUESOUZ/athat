package br.com.athat.core.entity.produto.categoria;

import javax.persistence.ManyToOne;

import br.com.athat.core.entity.AbstractEntity;

public abstract class AbstractCategoria extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	

}

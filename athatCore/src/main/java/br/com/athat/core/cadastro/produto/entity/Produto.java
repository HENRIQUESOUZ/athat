package br.com.athat.core.cadastro.produto.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.athat.core.cadastro.produto.categoria.entity.Categoria;
import br.com.athat.core.cadastro.produto.estoque.entity.Estoque;
import br.com.athat.core.entity.AbstractEntity;

@Entity
public class Produto extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@Column(length = 200, nullable=false)
    private String descricao;
	
	@ManyToOne(optional = false)
	private Categoria categoria;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Estoque estoque;
	
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
}    

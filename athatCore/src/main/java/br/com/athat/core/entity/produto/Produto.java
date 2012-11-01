package br.com.athat.core.entity.produto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.produto.categoria.Categoria;
import br.com.athat.core.entity.produto.estoque.Estoque;

@Entity
public class Produto extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(length = 100, nullable = false)
	private String nome;

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
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}    

package br.com.athat.core.entity.produto.estoque;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.produto.Produto;

@Entity
public class Estoque extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private Integer quantidade = 0;
	
	private Integer quantidadeDesmembrada = 0;
	
	@OneToOne
	private Produto produto;
	
	@OneToMany(fetch = FetchType.LAZY)
	@Column(nullable = false)
	private List<ItemEstoque> itemEstoqueList;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public List<ItemEstoque> getItemEstoqueList() {
		return itemEstoqueList;
	}

	public void setItemEstoqueList(List<ItemEstoque> itemEstoqueList) {
		this.itemEstoqueList = itemEstoqueList;
	}

	public Integer getQuantidadeDesmembrada() {
		return quantidadeDesmembrada;
	}

	public void setQuantidadeDesmembrada(Integer quantidadeDesmembrada) {
		this.quantidadeDesmembrada = quantidadeDesmembrada;
	}
}

package br.com.athat.core.entity.produto.estoque;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.produto.Produto;
import br.com.athat.core.entity.produto.tabelaPreco.TabelaPreco;
import java.math.RoundingMode;
import java.util.Collections;

@Entity
public class Estoque extends AbstractEntity{

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private Integer quantidade = 0;
	
	private Integer quantidadeDesmembrada = 0;
	
	@OneToOne
	private Produto produto;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Column(nullable = false)
	private List<ItemEstoque> itemEstoqueList;
	
	public BigDecimal getValorCusto() {
		BigDecimal valor = BigDecimal.ZERO;
                if(itemEstoqueList != null) {
                    Collections.reverse(itemEstoqueList);
                    BigDecimal valor1 = itemEstoqueList.get(0) != null ? itemEstoqueList.get(0).getValorCusto() : BigDecimal.ZERO;
                    BigDecimal valor2 = itemEstoqueList.get(1) != null ? itemEstoqueList.get(1).getValorCusto() : BigDecimal.ZERO;
                    BigDecimal valor3 = itemEstoqueList.get(2) != null ? itemEstoqueList.get(2).getValorCusto() : BigDecimal.ZERO;
                    valor = media(valor1, valor2, valor3);
                }
		return valor;
	}
        
         public BigDecimal calcularValorVenda(TabelaPreco tabelaPreco) {
            return tabelaPreco.getPorcentagem() != null ? getValorCusto().multiply(tabelaPreco.getPorcentagem()) : getValorCusto();
        }
        
        private BigDecimal media(BigDecimal valor1, BigDecimal valor2, BigDecimal valor3) {
            BigDecimal media = BigDecimal.ZERO;
            media = media.add(valor1).add(valor2).add(valor3);
            return media.divide(new BigDecimal(3), 2, RoundingMode.HALF_EVEN);
        }

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

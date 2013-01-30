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
import java.util.ArrayList;
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
                if(itemEstoqueList != null && !itemEstoqueList.isEmpty()) {
                    Collections.reverse(itemEstoqueList);
                    BigDecimal valor1 = BigDecimal.ZERO;
                    BigDecimal valor2 = BigDecimal.ZERO;
                    BigDecimal valor3 = BigDecimal.ZERO;
                    valor1 = itemEstoqueList.get(0) != null ? itemEstoqueList.get(0).getValorCusto() : BigDecimal.ZERO;
                    if(itemEstoqueList.size() > 2) {
                        valor2 = itemEstoqueList.get(1) != null ? itemEstoqueList.get(1).getValorCusto() : BigDecimal.ZERO;
                    }
                    if(itemEstoqueList.size() > 3) {
                        valor3 = itemEstoqueList.get(2) != null ? itemEstoqueList.get(2).getValorCusto() : BigDecimal.ZERO;
                    }
                    valor = media(valor1, valor2, valor3);
                }
		return valor;
	}
        
         public BigDecimal calcularValorVenda(TabelaPreco tabelaPreco) {
            BigDecimal vlrCusto = getValorCusto();
            return tabelaPreco.getPorcentagem() != null ? vlrCusto
                    .multiply(tabelaPreco.getPorcentagem()).divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN) 
                    .add(vlrCusto)
                    : getValorCusto().setScale(2, RoundingMode.HALF_EVEN);
        }
        
        private BigDecimal media(BigDecimal valor1, BigDecimal valor2, BigDecimal valor3) {
            int divisao = divisor(valor1,valor2,valor3);
            BigDecimal media = BigDecimal.ZERO;
            media = media.add(valor1).add(valor2).add(valor3);
            return media.divide(new BigDecimal(divisao), 2, RoundingMode.HALF_EVEN);
        }
        
        private int divisor(BigDecimal valor1, BigDecimal valor2, BigDecimal valor3) {
            int divisao = 0;
            if(valor1 != null && valor1.compareTo(BigDecimal.ZERO) > 0) {
                divisao++;
            } 
            if(valor2 != null && valor2.compareTo(BigDecimal.ZERO) > 0) {
                divisao++;
            } 
            if(valor3 != null && valor3.compareTo(BigDecimal.ZERO) > 0) {
                divisao++;
            } 
            return divisao;
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

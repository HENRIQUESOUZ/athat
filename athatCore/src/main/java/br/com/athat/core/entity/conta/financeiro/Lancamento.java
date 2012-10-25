package br.com.athat.core.entity.conta.financeiro;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.conta.Parcela;
@Entity
public class Lancamento extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal valor = BigDecimal.ZERO;
	private FormaPagamentoType formaPagamento;
	private MovimentoType tipoMovimento;
	@ManyToOne
	private Parcela parcela;
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public FormaPagamentoType getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamentoType formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public MovimentoType getTipoMovimento() {
		return tipoMovimento;
	}
	public void setTipoMovimento(MovimentoType tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	public Parcela getParcela() {
		return parcela;
	}
	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}
	


}

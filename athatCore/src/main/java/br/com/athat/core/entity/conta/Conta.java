package br.com.athat.core.entity.conta;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.movimentacao.Movimentacao;


@Entity
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
public  class Conta extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	protected BigDecimal valorTotal = BigDecimal.ZERO;
	
	@OneToMany(fetch = FetchType.LAZY)
	protected List<Parcela> parcelas;
	
	//@OneToOne
	protected Movimentacao movimentacao;
	
	@Enumerated(EnumType.STRING)
	protected SituacaoContaType situacao;
	
	@Enumerated(EnumType.STRING)
	protected ContaType tipoConta;
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public SituacaoContaType getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoContaType situacao) {
		this.situacao = situacao;
	}

	public ContaType getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(ContaType tipoConta) {
		this.tipoConta = tipoConta;
	}

}

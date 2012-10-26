package br.com.athat.core.entity.conta;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.movimentacao.Movimentacao;

@MappedSuperclass
public class Conta extends AbstractEntity {
	protected BigDecimal valorTotal = BigDecimal.ZERO;
	
	@OneToMany(fetch = FetchType.LAZY)
	protected List<Parcela> parcelas;
	@OneToOne
	protected Movimentacao movimentacao;
	
	protected SituacaoContaType situacao;
	
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

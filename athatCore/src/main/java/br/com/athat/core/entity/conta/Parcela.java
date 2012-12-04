package br.com.athat.core.entity.conta;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.conta.financeiro.Lancamento;

@Entity
public class Parcela extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Conta conta;

	@OneToMany(fetch=FetchType.LAZY)
	private List<Lancamento> lancamentos;
	
	@Enumerated(EnumType.STRING)
	private SituacaoContaType situacao;

	private int numParcela;
	
	private Date dataPagamento;

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public int getNumParcela() {
		return numParcela;
	}

	public void setNumParcela(int numParcela) {
		this.numParcela = numParcela;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public SituacaoContaType getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoContaType situacao) {
		this.situacao = situacao;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamentos.add(lancamento);
		
	}


}

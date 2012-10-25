package br.com.athat.core.entity.conta;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.conta.financeiro.Lancamento;

@Entity
public class Parcela extends AbstractEntity {
	@ManyToOne(fetch = FetchType.EAGER)
	private Conta conta;
	@OneToMany
	private List<Lancamento> lancamentos;
	
	private SituacaoContaType situacao;

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
	
	

}

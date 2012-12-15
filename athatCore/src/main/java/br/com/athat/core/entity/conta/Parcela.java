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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
public class Parcela extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Conta conta;

	@OneToMany(fetch=FetchType.EAGER)
        @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
	private List<Lancamento> lancamentos=new ArrayList<Lancamento>();
	
	@Enumerated(EnumType.STRING)
	private SituacaoContaType situacao;

	private int numParcela;
	
        @Temporal(javax.persistence.TemporalType.DATE)
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
        public BigDecimal getValorParcela(){
            BigDecimal valor=BigDecimal.ZERO;
            for (Lancamento lancamento:lancamentos) {
                valor=valor.add(lancamento.getValor());
            }
            
            return valor;
        }


}

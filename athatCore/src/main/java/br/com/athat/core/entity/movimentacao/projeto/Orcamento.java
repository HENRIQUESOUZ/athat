package br.com.athat.core.entity.movimentacao.projeto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.DiscriminatorOptions;

import org.hibernate.annotations.DiscriminatorOptions;

import br.com.athat.core.entity.movimentacao.enuns.OrcamentoType;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.pessoa.funcionario.Funcionario;

@Entity
@DiscriminatorValue("ORCAMENTO")
@DiscriminatorOptions(force = true)
public class Orcamento extends Levantamento {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "dataFinalizacaoOrcamento")
	protected Date dataFinalizacao;
	
	@ManyToOne
	@JoinColumn(name = "funcionarioOrcamento")
	private Funcionario funcionario;
	
	@Column(length = 2000, name = "observacaoOrcamento")
	private String observacao;
	
	private Date dataSaida;
	
	@Transient
	private Levantamento levantamento;
	
	public Orcamento() {
		this.orcamentoType = OrcamentoType.ORCAMENTO;
	}
	
	public Orcamento(Levantamento levantamento) {
		this.dataFinalizacao = levantamento.getDataFinalizacao();
		this.valorTotal = levantamento.getValorTotal();
		this.projeto = levantamento.getProjeto();
		this.itensMovimentacao = levantamento.getItensMovimentacao();
		this.situacaoMovimentacaoType = SituacaoMovimentacaoType.ABERTA;
		this.orcamentoType = OrcamentoType.ORCAMENTO;
		this.levantamento = levantamento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
	
	public Date getDataSaida() {
		return dataSaida;
	}
	
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
}

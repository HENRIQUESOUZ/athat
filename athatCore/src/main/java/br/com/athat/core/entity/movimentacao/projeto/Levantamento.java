package br.com.athat.core.entity.movimentacao.projeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DiscriminatorOptions;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.enuns.OrcamentoType;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.pessoa.funcionario.Funcionario;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("LEVANTAMENTO")
@DiscriminatorOptions(force = false)
public class Levantamento extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	protected BigDecimal valorTotal;
	
	@ManyToOne
	protected Projeto projeto;
	
	@OneToMany(fetch = FetchType.LAZY)
	protected List<ItemProduto> itensMovimentacao;
	
	@Enumerated(EnumType.STRING)
	protected SituacaoMovimentacaoType situacaoMovimentacaoType;
	
	@Enumerated(EnumType.STRING)
	protected OrcamentoType orcamentoType;
	
	@ManyToOne
	@JoinColumn(name = "funcionarioLevantamento")
	private Funcionario funcionario;
	
	@Column(name = "dataFinalizacaoLevantamento")
	private Date dataFinalizacao;
	
	@Column(length = 2000, name = "observacaoLevantamento")
	private String observacao;
	
	public Levantamento() {
		this.orcamentoType = OrcamentoType.LEVANTAMENTO;
		this.valorTotal = BigDecimal.ZERO;
	}

	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<ItemProduto> getItensMovimentacao() {
		return itensMovimentacao;
	}

	public void setItensMovimentacao(List<ItemProduto> itensMovimentacao) {
		this.itensMovimentacao = itensMovimentacao;
	}

	public SituacaoMovimentacaoType getSituacaoMovimentacaoType() {
		return situacaoMovimentacaoType;
	}

	public void setSituacaoMovimentacaoType(
			SituacaoMovimentacaoType situacaoMovimentacaoType) {
		this.situacaoMovimentacaoType = situacaoMovimentacaoType;
	}

	public OrcamentoType getOrcamentoType() {
		return orcamentoType;
	}

	public void setOrcamentoType(OrcamentoType orcamentoType) {
		this.orcamentoType = orcamentoType;
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
}

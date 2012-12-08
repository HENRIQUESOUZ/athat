package br.com.athat.core.entity.movimentacao.projeto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.enuns.OrcamentoType;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;

@Entity
public class Orcamento extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	private Date dataFinalizacao;
	
	private BigDecimal valorSugerido;
	
	@Column(length = 1000)
	private String observacao;
	
	@ManyToOne
	private Projeto projeto;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	protected List<ItemProduto> itensMovimentacao;
	
	@Enumerated(EnumType.STRING)
	private SituacaoMovimentacaoType situacaoMovimentacaoType;
	
	@Enumerated(EnumType.STRING)
	private OrcamentoType orcamentoType;

	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public BigDecimal getValorSugerido() {
		return valorSugerido;
	}

	public void setValorSugerido(BigDecimal valorSugerido) {
		this.valorSugerido = valorSugerido;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public void setSituacaoMovimentacaoType(SituacaoMovimentacaoType situacaoMovimentacaoType) {
		this.situacaoMovimentacaoType = situacaoMovimentacaoType;
	}

	public OrcamentoType getOrcamentoType() {
		return orcamentoType;
	}

	public void setOrcamentoType(OrcamentoType orcamentoType) {
		this.orcamentoType = orcamentoType;
	}

}

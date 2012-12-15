package br.com.athat.core.entity.pedido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.movimentacao.projeto.Orcamento;
import br.com.athat.core.entity.movimentacao.projeto.Projeto;

@Entity
public class PedidoCompra extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.DATE)
	private Date dataEncerramento;
	
	@ManyToOne
	private Projeto projeto;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItemProduto> itensMovimentacao;
	
	@Enumerated(EnumType.STRING)
	private SituacaoMovimentacaoType situacaoMovimentacaoType;
	
	public PedidoCompra() {}

	public PedidoCompra(Orcamento orcamento) {
		projeto = orcamento.getProjeto();
		itensMovimentacao = new ArrayList<ItemProduto>();
		for(ItemProduto it : orcamento.getItensMovimentacao()) {
			itensMovimentacao.add(new ItemProduto(it));
		}
		situacaoMovimentacaoType = SituacaoMovimentacaoType.ABERTA;
	}
	
	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
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
	
	public Projeto getProjeto() {
		return projeto;
	}
	
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}

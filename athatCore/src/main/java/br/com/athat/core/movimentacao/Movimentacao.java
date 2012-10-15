package br.com.athat.core.movimentacao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.athat.core.entity.AbstractEntity;
import br.com.athat.core.movimentacao.enuns.SituacaoMovimentacaoType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Movimentacao extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	protected BigDecimal valorTotal = BigDecimal.ZERO;
	
	@Temporal(TemporalType.DATE)
	protected Date dataEncerramento;
	
	@Enumerated
	protected SituacaoMovimentacaoType situacaoMovimentacaoType;
	
	@OneToMany(fetch = FetchType.LAZY)
	protected List<ItemProduto> itensMovimentacao;

        public BigDecimal getValorTotal() {
         return valorTotal;
        }
    
        public void setValorTotal(BigDecimal valorTotal) {
            this.valorTotal = valorTotal;
        }

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public SituacaoMovimentacaoType getSituacaoMovimentacaoType() {
		return situacaoMovimentacaoType;
	}

	public void setSituacaoMovimentacaoType(SituacaoMovimentacaoType situacaoMovimentacaoType) {
		this.situacaoMovimentacaoType = situacaoMovimentacaoType;
	}

	public List<ItemProduto> getItensMovimentacao() {
		return itensMovimentacao;
	}

	public void setItensMovimentacao(List<ItemProduto> itensMovimentacao) {
		this.itensMovimentacao = itensMovimentacao;
	}

}

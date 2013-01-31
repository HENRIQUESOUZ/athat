package br.com.athat.core.entity.movimentacao.venda;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.athat.core.entity.conta.ContaAReceber;
import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.Movimentacao;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.movimentacao.projeto.Orcamento;
import br.com.athat.core.entity.pessoa.cliente.Cliente;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Venda extends Movimentacao {

	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
    private Cliente cliente;
    
    @Temporal(TemporalType.DATE)
    private Date previsaoEntrega;
    
    @OneToOne
    @Cascade(CascadeType.PERSIST)
    private ContaAReceber contaAReceber;
    
    public Venda() {}

    public Venda(Orcamento orcamento) {
    	cliente = orcamento.getProjeto().getCliente();
    	valorTotal = orcamento.getValorTotal();
    	itensMovimentacao = new ArrayList<ItemProduto>();
    	for(ItemProduto it : orcamento.getItensMovimentacao()) {
            itensMovimentacao.add(new ItemProduto(it));
    	}
    	dataEncerramento = new Date();
    	situacaoMovimentacaoType = SituacaoMovimentacaoType.FECHADA;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(Date previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }

	public ContaAReceber getContaAReceber() {
		return contaAReceber;
	}

	public void setContaAReceber(ContaAReceber contaAReceber) {
		this.contaAReceber = contaAReceber;
	}
}

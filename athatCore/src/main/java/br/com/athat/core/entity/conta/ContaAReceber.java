package br.com.athat.core.entity.conta;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.athat.core.entity.movimentacao.Movimentacao;
import br.com.athat.core.entity.movimentacao.venda.Venda;

@Entity
public class ContaAReceber extends Conta {

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Venda venda;

	public Movimentacao getMovimentacao() {
		return venda;
	}

	public void setMovimentacao(Movimentacao venda) {
		this.venda = (Venda) venda;
	}
}

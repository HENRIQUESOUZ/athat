package br.com.athat.core.entity.conta;

import javax.persistence.Entity;

import br.com.athat.core.entity.movimentacao.Movimentacao;
import br.com.athat.core.entity.movimentacao.venda.Venda;

@Entity
public class ContaAReceber extends Conta {

	private static final long serialVersionUID = 1L;
	Venda venda =null;
	
	@Override
	public Movimentacao getMovimentacao() {
		
		return venda;
	}

	@Override
	public void setMovimentacao(Movimentacao movimentacao) {
		venda = (Venda) movimentacao;
		
	}
	
}

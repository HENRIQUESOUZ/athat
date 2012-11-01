package br.com.athat.core.entity.conta;

import javax.persistence.Entity;

import br.com.athat.core.entity.movimentacao.Movimentacao;
import br.com.athat.core.entity.movimentacao.compra.Compra;

@Entity
public class ContaAPagar extends Conta {

	private static final long serialVersionUID = 1L;

	private Compra compra;

	public Movimentacao getMovimentacao() {
		return compra;
	}

	public void setMovimentacao(Movimentacao compra) {
		this.compra = (Compra) compra;
	}
}

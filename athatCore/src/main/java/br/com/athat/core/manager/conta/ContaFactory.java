package br.com.athat.core.manager.conta;

import br.com.athat.core.entity.conta.ContaType;
import br.com.athat.core.entity.movimentacao.Movimentacao;

public class ContaFactory {
	public ContaManager contaAPagar(Movimentacao movimentacao){
		return new ContaManagerImpl(movimentacao,ContaType.PAGAR);
		
	}
	public ContaManager contaAReceber(Movimentacao movimentacao){
		return new ContaManagerImpl(movimentacao,ContaType.RECEBER);
		
	}
}

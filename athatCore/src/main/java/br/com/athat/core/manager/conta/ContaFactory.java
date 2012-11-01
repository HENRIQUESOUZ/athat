package br.com.athat.core.manager.conta;

import br.com.athat.core.entity.conta.ContaType;
import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.movimentacao.venda.Venda;

public class ContaFactory {
	public static ContaManager contaAPagar(Compra movimentacao){
		return new ContaManagerImpl(movimentacao,ContaType.PAGAR);
		
	}
	public static ContaManager contaAReceber(Venda movimentacao){
		return new ContaManagerImpl(movimentacao,ContaType.RECEBER);
		
	}
}

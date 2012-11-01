package br.com.athat.test.conta;

import org.junit.Test;

import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.movimentacao.venda.Venda;
import br.com.athat.core.manager.conta.ContaFactory;
import br.com.athat.core.manager.conta.ContaManager;

public class ContaManagerTest {

	@Test
	public void novoManagerCompra() {
		Compra compra =new Compra();
		ContaManager contaAPagar = ContaFactory.contaAPagar(compra);
		
	}
	
	@Test
	public void novoManagerVenda() {
		Venda venda = new Venda();
		ContaManager contaAPagar = ContaFactory.contaAReceber(venda);
		
	}

}

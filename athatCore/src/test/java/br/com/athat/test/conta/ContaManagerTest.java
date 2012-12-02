package br.com.athat.test.conta;

import org.junit.Test;
import br.com.athat.core.entity.conta.Conta;
import br.com.athat.core.entity.conta.ContaAPagar;
import br.com.athat.core.entity.conta.ContaAReceber;
import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.movimentacao.venda.Venda;

public class ContaManagerTest {

	@Test
	public void novoManagerCompra() {
		Compra compra =new Compra();
		Conta contaAPagar = new ContaAPagar();
		
	}
	
	@Test
	public void novoManagerVenda() {
		Venda venda = new Venda();
		Conta contaAReceber = new ContaAReceber();
		
	}

}

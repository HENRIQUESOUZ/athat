package br.com.athat.test.produto.tabelaPreco;

import java.math.BigDecimal;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.athat.core.AbstractTest;
import br.com.athat.core.Populate;
import br.com.athat.core.entity.produto.tabelaPreco.TabelaPreco;
import br.com.athat.core.manager.produto.tabelaPreco.TabelaPrecoManager;

public class TabelaPrecoManagerTest extends AbstractTest{
	
	@Autowired
	private TabelaPrecoManager tabelaPrecoManager;
	
	@Test
	public void save(){
		TabelaPreco tabelaPreco = Populate.populateTabelaPreco();
		
		tabelaPrecoManager.salvar(tabelaPreco);
		
	    Assert.assertNotNull(tabelaPreco.getId());
	    Assert.assertEquals(1, find(TabelaPreco.class).size());
	}
	
	@Test
	public void buscar(){
		popalate();
		
		TabelaPreco tabelaPreco = new TabelaPreco();
		
		tabelaPrecoManager.buscar(tabelaPreco);
		Assert.assertEquals(2, tabelaPrecoManager.buscar(tabelaPreco).size());
		
		tabelaPreco.setNome("A vista");
		Assert.assertEquals(1, tabelaPrecoManager.buscar(tabelaPreco).size());
		
	}
	
	private void popalate(){
		TabelaPreco tabelaPrecoBd1 = Populate.populateTabelaPreco();
		tabelaPrecoBd1.setNome("A vista");
		tabelaPrecoBd1.setPorcentagem(BigDecimal.valueOf(50).setScale(2));
		tabelaPrecoManager.salvar(tabelaPrecoBd1);
		
		TabelaPreco tabelaPrecoBd2 = Populate.populateTabelaPreco();
		tabelaPrecoBd1.setNome("A Prazo");
		tabelaPrecoBd1.setPorcentagem(BigDecimal.valueOf(70).setScale(2));
		tabelaPrecoManager.salvar(tabelaPrecoBd2);
		
	}


}

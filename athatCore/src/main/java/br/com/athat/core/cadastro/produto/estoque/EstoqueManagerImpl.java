package br.com.athat.core.cadastro.produto.estoque;

import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.movimentacao.ItemProduto;

public class EstoqueManagerImpl extends AbstractManager implements EstoqueManager {

	private static final long serialVersionUID = 1L;

	@Transactional
	public void entrar(ItemProduto itemProduto) {
		getEntityManager().merge(itemProduto);
	}
	
	@Transactional
	public void sair(ItemProduto itemProduto) {
		getEntityManager().merge(itemProduto);
	}
}

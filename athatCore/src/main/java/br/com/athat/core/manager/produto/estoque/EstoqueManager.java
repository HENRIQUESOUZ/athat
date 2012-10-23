package br.com.athat.core.manager.produto.estoque;

import br.com.athat.core.entity.movimentacao.ItemProduto;

public interface EstoqueManager {
	
	void entrar(ItemProduto itemProduto);
	
	void sair(ItemProduto itemProduto);

}

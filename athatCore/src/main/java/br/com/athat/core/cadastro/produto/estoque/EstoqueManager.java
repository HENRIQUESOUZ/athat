package br.com.athat.core.cadastro.produto.estoque;

import br.com.athat.core.movimentacao.ItemProduto;

public interface EstoqueManager {
	
	void entrar(ItemProduto itemProduto);
	
	void sair(ItemProduto itemProduto);

}

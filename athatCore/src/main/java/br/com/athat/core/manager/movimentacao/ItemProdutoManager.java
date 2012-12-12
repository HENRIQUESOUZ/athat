package br.com.athat.core.manager.movimentacao;

import java.util.List;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.manager.AbstractManager;

public interface ItemProdutoManager extends AbstractManager {
	
	void salvar(List<ItemProduto> itensProduto);

}

package br.com.athat.core.manager.produto;

import java.util.List;

import br.com.athat.core.entity.produto.Produto;

public interface ProdutoManager {

	void salvar(Produto produto);
	
	List<Produto> buscar(Produto produto);
	
	List<Produto> buscarComEstoque(Produto produto);

	Produto buscarPorId(Long id);
	
}

package br.com.athat.core.cadastro.produto.manager;

import java.util.List;
import br.com.athat.core.cadastro.produto.entity.Produto;

public interface ProdutoManager {

	void salvar(Produto produto);
	
	List<Produto> buscar(Produto produto);

	Produto buscarPorId(Long id);
	
}

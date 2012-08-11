package br.com.athat.core.cadastro.produto.tabelaPreco.manager;

import java.util.List;
import br.com.athat.core.cadastro.produto.tabelaPreco.entity.TabelaPreco;

public interface TabelaPrecoManager {

	void salvar(TabelaPreco tabelaPreco);
	
	List<TabelaPreco> buscar(TabelaPreco tabelaPreco);

	TabelaPreco buscarPorId(Long id);
	
}

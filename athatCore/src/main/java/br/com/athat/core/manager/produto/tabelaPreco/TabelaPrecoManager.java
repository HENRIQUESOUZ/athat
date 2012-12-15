package br.com.athat.core.manager.produto.tabelaPreco;

import java.util.Date;
import java.util.List;

import br.com.athat.core.entity.produto.tabelaPreco.TabelaPreco;

public interface TabelaPrecoManager {

	void salvar(TabelaPreco tabelaPreco);
	
	List<TabelaPreco> buscar(TabelaPreco tabelaPreco);

	TabelaPreco buscarPorId(Long id);
	
	TabelaPreco buscarTabelaVigente(Date data);
	
}

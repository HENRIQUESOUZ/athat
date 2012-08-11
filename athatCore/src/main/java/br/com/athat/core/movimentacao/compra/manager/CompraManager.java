package br.com.athat.core.movimentacao.compra.manager;

import java.util.List;

import br.com.athat.core.movimentacao.compra.entity.Compra;

public interface CompraManager{
	
	void salvar(Compra compra);
	
	List<Compra> buscar(Compra compra);

}

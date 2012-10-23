package br.com.athat.core.manager.movimentacao.compra;

import java.util.List;

import br.com.athat.core.entity.movimentacao.compra.Compra;

public interface CompraManager{
	
	Compra salvar(Compra compra);
	
	List<Compra> buscar(Compra compra);
        

}

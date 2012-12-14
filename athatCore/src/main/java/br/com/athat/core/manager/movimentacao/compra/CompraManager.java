package br.com.athat.core.manager.movimentacao.compra;

import java.util.List;

import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.pedido.PedidoCompra;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.vo.compra.CompraVO;

public interface CompraManager extends AbstractManager {
	
	Compra salvar(Compra compra);
	
	void salvar(List<Compra> compras, PedidoCompra pedidoCompra);
	
	List<Compra> buscar(CompraVO compra);
        
	void entrada(Compra compra);
	
	Compra buscarCompraPorIdFull(Long id);
	
}

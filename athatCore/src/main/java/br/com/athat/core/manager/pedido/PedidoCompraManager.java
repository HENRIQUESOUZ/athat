package br.com.athat.core.manager.pedido;

import java.util.List;

import br.com.athat.core.entity.pedido.PedidoCompra;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.vo.pedido.PedidoCompraVO;

public interface PedidoCompraManager extends AbstractManager {
	
	void salvar(PedidoCompra pedidoCompra);
	
	List<PedidoCompra> buscar(PedidoCompraVO pedidoCompraVO);

}

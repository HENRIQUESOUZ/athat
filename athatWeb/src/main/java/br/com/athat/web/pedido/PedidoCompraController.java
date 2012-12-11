package br.com.athat.web.pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.pedido.PedidoCompra;
import br.com.athat.core.manager.pedido.PedidoCompraManager;
import br.com.athat.core.vo.pedido.PedidoCompraVO;
import br.com.athat.web.utils.AbstractController;

public class PedidoCompraController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private PedidoCompra pedidoCompra;
	private List<PedidoCompra> pedidosCompra;
	private PedidoCompraVO pedidoCompraVO;
	
	@Autowired
	private PedidoCompraManager pedidoCompraManager;
	
	public PedidoCompraController() {
		init();
	}
	
	public void buscar() {
		pedidosCompra = pedidoCompraManager.buscar(pedidoCompraVO);
	}
	
	private void init() {
		pedidoCompra = new PedidoCompra();
		pedidosCompra  = new ArrayList<PedidoCompra>();
		pedidoCompraVO = new PedidoCompraVO();
	}

	public PedidoCompra getPedidoCompra() {
		return pedidoCompra;
	}

	public void setPedidoCompra(PedidoCompra pedidoCompra) {
		this.pedidoCompra = pedidoCompra;
	}

	public List<PedidoCompra> getPedidosCompra() {
		return pedidosCompra;
	}

	public void setPedidosCompra(List<PedidoCompra> pedidosCompra) {
		this.pedidosCompra = pedidosCompra;
	}

	public PedidoCompraVO getPedidoCompraVO() {
		return pedidoCompraVO;
	}

	public void setPedidoCompraVO(PedidoCompraVO pedidoCompraVO) {
		this.pedidoCompraVO = pedidoCompraVO;
	}
}

package br.com.athat.web.pedido;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.ItemProduto;
import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.pedido.PedidoCompra;
import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.core.entity.pessoa.fornecedor.Fornecedor;
import br.com.athat.core.manager.movimentacao.compra.CompraManager;
import br.com.athat.core.manager.pedido.PedidoCompraManager;
import br.com.athat.core.vo.pedido.PedidoCompraVO;
import br.com.athat.web.utils.AbstractController;

public class PedidoCompraController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private PedidoCompra pedidoCompra;
	private List<PedidoCompra> pedidosCompra;
	private PedidoCompraVO pedidoCompraVO;
	
	private ItemProduto[] selectedItens;
	private Compra compra;
	private List<Compra> compras;
	
	@Autowired
	private PedidoCompraManager pedidoCompraManager;
	
	@Autowired
	private CompraManager compraManager;
	
	public PedidoCompraController() {
		init();
	}
	
	public void buscar() {
		pedidosCompra = pedidoCompraManager.buscar(pedidoCompraVO);
	}
	
	public void preprararCompra() {
		compra = new Compra();
		compra.setFornecedor(new Fornecedor());
		compra.getFornecedor().setPessoa(new Pessoa());
		prepararItensProduto();
	}
	
	public void adicionarCompra() {
		compras.add(compra);
	}
	
	public void removerCompra() {
		pedidoCompra.getItensMovimentacao().addAll(compra.getItensMovimentacao());
		compras.remove(compra);
	}
	
	public String gerarComprar() {
		try {
			compraManager.salvar(compras, pedidoCompra);
			setMessage("Compras geradas com sucesso!");
			init();
		} catch(Exception e) {
			e.printStackTrace();
			getMessageInstabilidade();
		}
		return "/pages/pedido/listagemPedidoCompra?faces-redirect=true";
	}
	
	public void validaFornecedor(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        Fornecedor fornecedor = (Fornecedor) event.getComponent().getAttributes().get("pessoa");
    	if (fornecedor == null) {
    		context.addCallbackParam("confirmar", false);
    		setMessage("Fornecedor não selecionado.");
    	} else {
    		context.addCallbackParam("confirmar", true);                
    		compra.setFornecedor(fornecedor);
    	}
    }
	
	private void prepararItensProduto() {
		compra.setItensMovimentacao(new ArrayList<ItemProduto>());
		List<ItemProduto> list = Arrays.asList(selectedItens);
		for(ItemProduto it : list) {
			compra.getItensMovimentacao().add(new ItemProduto(it));
		}
		pedidoCompra.getItensMovimentacao().removeAll(list);
	}
	
	private void init() {
		pedidoCompra = new PedidoCompra();
		pedidosCompra  = new ArrayList<PedidoCompra>();
		pedidoCompraVO = new PedidoCompraVO();
		compras = new ArrayList<Compra>();
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
	
	public ItemProduto[] getSelectedItens() {
		return selectedItens;
	}
	
	public void setSelectedItens(ItemProduto[] selectedItens) {
		this.selectedItens = selectedItens;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
}

package br.com.athat.web.movimentacao.entrada;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoEntradaType;
import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.manager.movimentacao.compra.CompraManager;
import br.com.athat.core.vo.compra.CompraVO;
import br.com.athat.web.utils.AbstractController;

public class EntradaController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private CompraVO compraVO;
	private List<Compra> compras;
	private Compra compra;
	
	@Autowired
	private CompraManager compraManager;
	
	public EntradaController() {
		limpar();
	}
	
	public String entrar() {
		try {
			compra.setSituacaoEntradaType(SituacaoEntradaType.EFETIVADO);
			compraManager.entrada(compra);
			
			setMessage("Entrada efeituada com sucesso!");
			limpar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/pages/movimentacao/listagemEntrada?faces-redirect=true";
	}
	
	public void buscar() {
		compraVO.setSituacaoEntradaType(SituacaoEntradaType.AGUARDANDO);
		compraVO.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.FECHADA);
		compras = compraManager.buscar(compraVO);
	}
	
	public String carregarCompra(){
		compra = compraManager.buscarCompraPorIdFull(Long.valueOf(compra.getId()));
		return "/pages/movimentacao/entrada?faces-redirect=true"; 
	}
	
//	public BigDecimal getValorTotal() {
//		BigDecimal total = BigDecimal.ZERO;
//		for(ItemProduto it: compra.getItensMovimentacao()) {
//			total = total.add(it.getValorTotal());
//		}
//		return total;
//	}
	
	private void limpar() {
		compra = new Compra();
		compras = new ArrayList<Compra>();
		compraVO = new CompraVO();
	}
	
	public Compra getCompra() {
		return compra;
	}
	
	public List<Compra> getCompras() {
		return compras;
	}
	
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public CompraVO getCompraVO() {
		return compraVO;
	}
	
	public void setCompraVO(CompraVO compraVO) {
		this.compraVO = compraVO;
	}
	
	public CompraManager getCompraManager() {
		return compraManager;
	}

	public void setCompraManager(CompraManager compraManager) {
		this.compraManager = compraManager;
	}
}

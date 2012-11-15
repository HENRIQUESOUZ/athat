package br.com.athat.web.controller.entrada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.compra.Compra;
import br.com.athat.core.manager.movimentacao.compra.CompraManager;
import br.com.athat.web.utils.AbstractController;

public class EntradaController extends AbstractController {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	private Long codigoCompra;
	private String numeroNF;
	private List<Compra> compras;
	private Compra compra;
	
	@Autowired
	private CompraManager compraManager;
	
	public void carregar() {
		
	}
	
	public String entrar() {
		compraManager.entrada(compra);
		
		return "/pages/movimentacao/entrada";
	}
	
	public void buscar() {
		Compra c = new Compra();
		c.setId(codigoCompra);
		c.setNotaFiscal(numeroNF);
		compras = compraManager.buscar(c);
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

}

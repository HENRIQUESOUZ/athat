package br.com.athat.web.pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.athat.core.entity.movimentacao.enuns.SituacaoMovimentacaoType;
import br.com.athat.core.entity.movimentacao.projeto.Orcamento;
import br.com.athat.core.manager.movimentacao.projeto.LevantamentoManager;
import br.com.athat.core.vo.projeto.OrcamentoVO;
import br.com.athat.web.utils.AbstractController;

public class PedidoVendaController extends AbstractController {

	private static final long serialVersionUID = 1L;
	
	private Orcamento pedidoVenda;
	private List<Orcamento> pedidosVenda;
	private OrcamentoVO pedidoVendaVO;
	
	@Autowired
	private LevantamentoManager pedidoVendaManager;
	
	public PedidoVendaController() {
		init();
	}
	
	public void buscar() {
		pedidoVendaVO.setSituacaoMovimentacaoType(SituacaoMovimentacaoType.FECHADA);
		pedidosVenda = pedidoVendaManager.buscar(pedidoVendaVO);
	}

	public void confirmar() {
		buscar();
	}
	
	private void init() {
		pedidoVenda = new Orcamento();
		pedidosVenda  = new ArrayList<Orcamento>();
		pedidoVendaVO = new OrcamentoVO();
	}

	public Orcamento getPedidoVenda() {
		return pedidoVenda;
	}

	public void setPedidoVenda(Orcamento pedidoVenda) {
		this.pedidoVenda = pedidoVenda;
	}

	public List<Orcamento> getPedidosVenda() {
		return pedidosVenda;
	}

	public void setPedidosVenda(List<Orcamento> pedidosVenda) {
		this.pedidosVenda = pedidosVenda;
	}

	public OrcamentoVO getPedidoVendaVO() {
		return pedidoVendaVO;
	}

	public void setPedidoVendaVO(OrcamentoVO pedidoVendaVO) {
		this.pedidoVendaVO = pedidoVendaVO;
	}

	public LevantamentoManager getPedidoVendaManager() {
		return pedidoVendaManager;
	}

	public void setPedidoVendaManager(LevantamentoManager pedidoVendaManager) {
		this.pedidoVendaManager = pedidoVendaManager;
	}

}

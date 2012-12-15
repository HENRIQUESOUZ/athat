package br.com.athat.core.manager.movimentacao.projeto;

import java.util.List;

import br.com.athat.core.entity.movimentacao.projeto.Levantamento;
import br.com.athat.core.entity.movimentacao.projeto.Orcamento;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.vo.projeto.LenvamentoVO;
import br.com.athat.core.vo.projeto.OrcamentoVO;

public interface LevantamentoManager extends AbstractManager {
	
	void salvar(Orcamento orcamento);
	
	void salvar(Orcamento orcamento, Levantamento levantamento);
	
	void salvar(Levantamento levantamento);
	
	List<Levantamento> buscar(LenvamentoVO levantamento);
	
	List<Orcamento> buscar(OrcamentoVO orcamento);
	
	List<Levantamento> buscarOrcApresentacaoProjeto(Long idProjeto);
	
	Levantamento buscarLevantamentoPorIdFull(Long id);
	
	Orcamento buscarOrcamentoPorIdFull(Long id);
	
	void finalizarOrcamento(Orcamento orcamento);
	
	void confirmarChegadaPedidoVenda(Orcamento pedido);
	
}

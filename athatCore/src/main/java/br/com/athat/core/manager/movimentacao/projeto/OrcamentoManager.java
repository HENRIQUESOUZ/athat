package br.com.athat.core.manager.movimentacao.projeto;

import java.util.List;

import br.com.athat.core.entity.movimentacao.projeto.Orcamento;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.vo.projeto.OrcamentoVO;

public interface OrcamentoManager extends AbstractManager {
	
	void salvar(Orcamento levantamento);
	
	List<Orcamento> buscar(OrcamentoVO levantamento);
	
	List<Orcamento> buscarOrcApresentacaoProjeto(Long idProjeto);
	
}

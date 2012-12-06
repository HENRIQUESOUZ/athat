package br.com.athat.core.manager.movimentacao.projeto;

import java.util.List;

import br.com.athat.core.entity.movimentacao.projeto.Levantamento;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.vo.projeto.LevantamentoVO;

public interface LevantamentoManager extends AbstractManager {
	
	void salvar(Levantamento levantamento);
	
	List<Levantamento> buscar(LevantamentoVO levantamento);
	
}

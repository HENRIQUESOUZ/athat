package br.com.athat.core.manager.movimentacao.projeto;

import java.util.List;

import br.com.athat.core.entity.movimentacao.projeto.Projeto;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.vo.projeto.ProjetoVO;

public interface ProjetoManager extends AbstractManager {
	
	void salvar(Projeto projeto);
	
	List<Projeto> buscar(ProjetoVO projeto);
	
}

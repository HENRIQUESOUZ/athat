package br.com.athat.core.manager.movimentacao.projeto;

import br.com.athat.core.entity.movimentacao.projeto.Projeto;
import br.com.athat.core.manager.AbstractManager;

public interface ProjetoManager extends AbstractManager {
	
	void salvar(Projeto projeto);

}

package br.com.athat.core.manager.movimentacao.projeto;

import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.movimentacao.projeto.Projeto;
import br.com.athat.core.manager.AbstractManagerImpl;

public class ProjetoManagerImpl extends AbstractManagerImpl implements ProjetoManager {

	private static final long serialVersionUID = 1L;

	@Transactional
	@Override
	public void salvar(Projeto projeto) {
		if(projeto.getId() == null) {
			getEntityManager().persist(projeto);
		} else {
			getEntityManager().merge(projeto);
		}
	}
}

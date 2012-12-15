package br.com.athat.core.manager.conta;

import br.com.athat.core.entity.conta.financeiro.Lancamento;
import br.com.athat.core.manager.AbstractManagerImpl;
import org.springframework.transaction.annotation.Transactional;

public class LancamentoManagerImpl extends AbstractManagerImpl implements LancamentoManager {
    
	
       @Transactional
    @Override
    public void salvar(Lancamento lancamento) {
        if (lancamento.getId() == null) {

            getEntityManager().persist(lancamento);
        } else {

            getEntityManager().merge(lancamento);
        }

    }

}

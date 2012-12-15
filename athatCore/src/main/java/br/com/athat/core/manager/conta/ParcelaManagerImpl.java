package br.com.athat.core.manager.conta;

import br.com.athat.core.entity.conta.ContaAPagar;
import br.com.athat.core.entity.conta.Parcela;
import br.com.athat.core.entity.conta.financeiro.Lancamento;
import br.com.athat.core.manager.AbstractManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ParcelaManagerImpl extends AbstractManagerImpl implements ParcelaManager {
    @Autowired
    private LancamentoManager lancamentoManager;
	
       @Transactional
    @Override
    public void salvar(Parcela parcela) {
        if (parcela.getId() == null) {
            getEntityManager().persist(parcela);
        } else {
            getEntityManager().merge(parcela);
        }

    }

}

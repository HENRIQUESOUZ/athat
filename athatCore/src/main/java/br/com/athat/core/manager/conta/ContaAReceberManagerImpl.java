package br.com.athat.core.manager.conta;

import java.util.List;

import br.com.athat.core.entity.conta.Conta;
import br.com.athat.core.entity.conta.ContaAReceber;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.manager.AbstractManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ContaAReceberManagerImpl extends AbstractManagerImpl implements ContaAReceberManager {

    private static final long serialVersionUID = 1L;
    private ContaAReceber conta;
    @Autowired
    private ParcelaManager parcela;

    @Transactional
    @Override
    public void salvar(ContaAReceber conta) {
        if (conta.getId() == null) {
            getEntityManager().persist(conta);
        } else {
            getEntityManager().merge(conta);
        }
    }

    @Override
    public List<Conta> buscarTodos(ContaAReceber conta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

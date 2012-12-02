package br.com.athat.core.manager.conta;

import java.util.List;

import br.com.athat.core.entity.conta.Conta;
import br.com.athat.core.entity.conta.ContaAPagar;
import br.com.athat.core.manager.AbstractManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ContaAPagarManagerImpl extends AbstractManager implements ContaAPagarManager {


	private static final long serialVersionUID = 1L;

	private ContaAPagar conta;
        @Autowired
        private ParcelaManager parcela;

	
	@Transactional
    @Override
	public void salvar(ContaAPagar conta) {
	if(conta.getId() == null)
            getEntityManager().persist(conta);
        else
            getEntityManager().merge(conta);

	}



	@Override
	public List<Conta> buscarTodos(ContaAPagar conta) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

package br.com.athat.core.manager.conta;

import java.util.List;

import br.com.athat.core.entity.conta.Conta;
import br.com.athat.core.entity.conta.ContaAReceber;
import br.com.athat.core.entity.conta.Parcela;
import br.com.athat.core.entity.conta.SituacaoContaType;
import br.com.athat.core.entity.produto.Produto;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.utils.validators.ValidatorUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ContaAReceberManagerImpl extends AbstractManagerImpl implements ContaAReceberManager {

    private static final long serialVersionUID = 1L;
    private ContaAReceber conta;
    @Autowired
    private ParcelaManager parcelaManager;

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
    @Transactional(readOnly=true)
    public List<Conta> buscarContaAberta() {
        Criteria criteria = createSession().createCriteria(ContaAReceber.class, "c")
                .add(Restrictions.eq("c.situacao", SituacaoContaType.ABERTA));

        return criteria.list();
    }
}

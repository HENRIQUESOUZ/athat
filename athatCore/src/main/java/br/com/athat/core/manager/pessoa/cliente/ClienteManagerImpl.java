package br.com.athat.core.manager.pessoa.cliente;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.pessoa.cliente.Cliente;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.utils.validators.ValidatorUtils;

public class ClienteManagerImpl extends AbstractManagerImpl implements ClienteManager{

	private static final long serialVersionUID = 1L;

	@Transactional
    public void salvar(Cliente cliente) {
          
        if(cliente.getId() != null){
            getEntityManager().persist(cliente);
        }else{
            getEntityManager().merge(cliente);    
        }    
    }
    
	@SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Cliente> buscarTodos(Cliente cliente) {
        Criteria criteria = createSession().createCriteria(Cliente.class)
        		.createAlias("pessoa", "p",CriteriaSpecification.INNER_JOIN);
        
        if(ValidatorUtils.isNotEmptyAndNotNull(cliente.getPessoa().getNomeRazao()))
            criteria.add(Restrictions.like("p.nomeRazao", cliente.getPessoa().getNomeRazao(),MatchMode.START));
        
        if(ValidatorUtils.isNotEmptyAndNotNull(cliente.getPessoa().getCpfCnpj()))
            criteria.add(Restrictions.eq("p.cpfCnpj", cliente.getPessoa().getCpfCnpj()));
        
        return criteria.list();
    }

	@Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
		return getEntityManager().find(Cliente.class, id);
	}
}

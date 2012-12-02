package br.com.athat.core.manager.pessoa.fornecedor;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.pessoa.fornecedor.Fornecedor;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.utils.validators.ValidatorUtils;

public class FornecedorManagerImpl extends AbstractManagerImpl implements FornecedorManager{

	private static final long serialVersionUID = 1L;

	@Transactional
    public void salvar(Fornecedor fornecedor) {
          
        if(fornecedor.getId() != null){
            getEntityManager().persist(fornecedor);
        }else{
            getEntityManager().merge(fornecedor);    
        }    
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Fornecedor> buscarTodos(Fornecedor fornecedor) {
        Criteria criteria = createSession().createCriteria(Fornecedor.class)
        		.createAlias("pessoa", "p")
        ;
        
        if(ValidatorUtils.isNotEmptyAndNotNull(fornecedor.getPessoa().getNomeRazao()))
            criteria.add(Restrictions.like("p.nomeRazao", fornecedor.getPessoa().getNomeRazao(),MatchMode.START));
        
        if(ValidatorUtils.isNotEmptyAndNotNull(fornecedor.getPessoa().getCpfCnpj()))
            criteria.add(Restrictions.eq("p.cpfCnpj", fornecedor.getPessoa().getCpfCnpj()));
        
        if(fornecedor.getFornecedorType() != null)
        	criteria.add(Restrictions.eq("fornecedorType", fornecedor.getFornecedorType()));
        
        return criteria.list();
    }

    @Transactional(readOnly = true)
	public Fornecedor buscarPorId(Long id) {
		return getEntityManager().find(Fornecedor.class, id);
	}
    
}

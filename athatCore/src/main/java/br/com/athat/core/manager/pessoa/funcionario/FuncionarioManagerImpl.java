package br.com.athat.core.manager.pessoa.funcionario;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.pessoa.funcionario.Funcionario;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.utils.validators.ValidatorUtils;

public class FuncionarioManagerImpl extends AbstractManagerImpl implements FuncionarioManager{

	private static final long serialVersionUID = 1L;

	@Transactional
    public void salvar(Funcionario funcionario) {
          
        if(funcionario.getId() != null){
            getEntityManager().persist(funcionario);
        }else{
            getEntityManager().merge(funcionario);    
        }    
    }

    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Funcionario> buscarTodos(Funcionario funcionario) {
        Criteria criteria = createSession().createCriteria(Funcionario.class)
        		.createAlias("pessoa", "p")
        		;
        
        if(ValidatorUtils.isNotEmptyAndNotNull(funcionario.getPessoa().getNomeRazao()))
            criteria.add(Restrictions.like("p.nomeRazao", funcionario.getPessoa().getNomeRazao(),MatchMode.START));
        
        if(ValidatorUtils.isNotEmptyAndNotNull(funcionario.getPessoa().getCpfCnpj()))
            criteria.add(Restrictions.eq("p.cpfCnpj", funcionario.getPessoa().getCpfCnpj()));
        
        return criteria.list();
    }

    @Transactional(readOnly = false)
	public Funcionario buscarPorId(Long id) {
		return getEntityManager().find(Funcionario.class, id);
	}
}

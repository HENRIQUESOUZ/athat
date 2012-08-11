package br.com.athat.core.cadastro.pessoa.funcionario.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.cadastro.pessoa.funcionario.entity.Funcionario;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.utils.validators.ValidatorUtils;

public class FuncionarioManagerImpl extends AbstractManager implements FuncionarioManager{

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

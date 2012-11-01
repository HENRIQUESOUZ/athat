package br.com.athat.core.manager.pessoa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.pessoa.Papel;
import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.core.entity.pessoa.cliente.Cliente;
import br.com.athat.core.entity.pessoa.fornecedor.Fornecedor;
import br.com.athat.core.entity.pessoa.funcionario.Funcionario;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.utils.validators.ValidatorUtils;

public class PessoaManagerImpl extends AbstractManager implements PessoaManager {

	private static final long serialVersionUID = 1L;

	@Override
	@Transactional(readOnly = true)
    public Pessoa findByCpfCnpj(String cpfCnpj) {
    	Pessoa pessoa = new Pessoa();
        
        Criteria criteria = createSession().createCriteria(Pessoa.class)
                .add(Restrictions.eq("cpfCnpj", cpfCnpj))
        ;
        
        pessoa = (Pessoa) criteria.uniqueResult();
        if(pessoa != null){
        	Hibernate.initialize(pessoa.getEnderecos());
            Hibernate.initialize(pessoa.getTelefones());
        }
       
        return pessoa;
    }

    @Override
    @Transactional(readOnly =  true)
	public Pessoa buscarPorId(Long id) {
		return getEntityManager().find(Pessoa.class, id);
	}
	
    @Override
    @Transactional(readOnly =  true)
	public Pessoa buscarPorIdCompleto(Long id) {
		Pessoa pessoa = getEntityManager().find(Pessoa.class, id);
		Hibernate.initialize(pessoa.getEnderecos());
		Hibernate.initialize(pessoa.getTelefones());
		
		return pessoa;
	}

    
	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Papel> buscaGenericaPop(Long id, String cpfCnpj, String razaoSocial, Object tipoClasse) {
		Criteria criteria = null;
		
		if (tipoClasse instanceof Cliente) {
			criteria = createSession().createCriteria(Cliente.class, "c");
		} else if (tipoClasse instanceof Fornecedor) {
				criteria = createSession().createCriteria(Fornecedor.class, "c");
		} else if (tipoClasse instanceof Funcionario) {
				criteria = createSession().createCriteria(Funcionario.class, "c");
		}
		
		criteria.createAlias("pessoa", "p");
		
		if(ValidatorUtils.isNotEmptyAndNotNull(cpfCnpj)) {
			criteria.add(Restrictions.like("p.nomeRazao", cpfCnpj ,MatchMode.START));
		}	
		
		if(ValidatorUtils.isNotEmptyAndNotNull(razaoSocial)) {
	    	  criteria.add(Restrictions.eq("p.cpfCnpj", razaoSocial));
		}	  
			
		return criteria.list();
	}
}

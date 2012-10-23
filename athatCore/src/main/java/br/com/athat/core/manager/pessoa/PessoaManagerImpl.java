package br.com.athat.core.manager.pessoa;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.pessoa.Pessoa;
import br.com.athat.core.manager.AbstractManager;

public class PessoaManagerImpl extends AbstractManager implements PessoaManager{

	private static final long serialVersionUID = 1L;

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

    @Transactional(readOnly =  true)
	public Pessoa buscarPorId(Long id) {
		return getEntityManager().find(Pessoa.class, id);
	}
	
    @Transactional(readOnly =  true)
	public Pessoa buscarPorIdCompleto(Long id) {
		Pessoa pessoa = getEntityManager().find(Pessoa.class, id);
		Hibernate.initialize(pessoa.getEnderecos());
		Hibernate.initialize(pessoa.getTelefones());
		
		return pessoa;
	}
}

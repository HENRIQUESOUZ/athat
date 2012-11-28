package br.com.athat.core.manager.pessoa;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.pessoa.endereco.Cidade;
import br.com.athat.core.entity.pessoa.endereco.EstadoType;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.utils.validators.ValidatorUtils;

public class CidadeManagerImpl extends AbstractManagerImpl implements CidadeManager {

	private static final long serialVersionUID = 1L;

	@Transactional
	public void salvar(Cidade cidade) {
        if (cidade.getId() == null)
            getEntityManager().persist(cidade);
        else
            getEntityManager().merge(cidade);
    }
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public List<Cidade> buscarTodos(Cidade cidade) {
        Criteria criteria = createSession().createCriteria(Cidade.class)
        		.add(Restrictions.eq("estadoType", cidade.getEstadoType()));
        
        if(ValidatorUtils.isNotEmptyAndNotNull(cidade.getNome()))
            criteria.add(Restrictions.like("nome", cidade.getNome(),MatchMode.START));
        
        if(ValidatorUtils.isNotEmptyAndNotNull(cidade.getIbge()))
            criteria.add(Restrictions.eq("ibge", cidade.getIbge()));
        
        return criteria.list();
    }

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Cidade> buscarPorEstado(EstadoType estadoType) {
		Criteria criteria = createSession().createCriteria(Cidade.class)
				.add(Restrictions.eq("estadoType", estadoType))
		;
		
		return criteria.list();
	}

	@Transactional(readOnly = true)
	public Cidade buscarPorId(Long id) {
		return getEntityManager().find(Cidade.class,id);
	}

}

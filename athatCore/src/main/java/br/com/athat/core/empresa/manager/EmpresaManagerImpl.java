package br.com.athat.core.empresa.manager;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import br.com.athat.core.cadastro.empresa.entity.Empresa;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.utils.validators.ValidatorUtils;

public class EmpresaManagerImpl extends AbstractManager implements EmpresaManager{

	private static final long serialVersionUID = 1L;

	@Transactional
    public void salvar(Empresa empresa) {
        if(empresa.getId() == null)
            getEntityManager().persist(empresa);
        else
            getEntityManager().merge(empresa);
    }

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Empresa> buscar(Empresa empresa) {
		Criteria criteria = createSession().createCriteria(Empresa.class);
		
		if(ValidatorUtils.isNotEmptyAndNotNull(empresa.getNome()))
				criteria.add(Restrictions.like("nome", empresa.getNome(), MatchMode.START));
		
		return criteria.list();
	}

	@Transactional(readOnly = true)
	public Empresa buscarPorId(Long id) {
		return getEntityManager().find(Empresa.class, id);
	}
    
}

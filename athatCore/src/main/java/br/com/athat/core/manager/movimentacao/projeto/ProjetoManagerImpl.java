package br.com.athat.core.manager.movimentacao.projeto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.movimentacao.projeto.Projeto;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.core.vo.projeto.ProjetoVO;
import br.com.athat.utils.validators.DateUtils;

public class ProjetoManagerImpl extends AbstractManagerImpl implements ProjetoManager {

	private static final long serialVersionUID = 1L;
	
	@Transactional
	@Override
	public void salvar(Projeto projeto) {
		if(projeto.getId() == null) {
			getEntityManager().persist(projeto);
		} else {
			getEntityManager().merge(projeto);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
	public List<Projeto> buscar(ProjetoVO projeto) {
		Criteria criteria = createSession().createCriteria(Projeto.class)
			.add(Restrictions.between("dataCadastro", 
				DateUtils.zerarHoras(projeto.getDataInicio()), DateUtils.horasFinal(projeto.getDataFim())))
		;
//		if(projeto.getId() != null) {
//			criteria.add(Restrictions.eq("id", projeto.getId()));
//		}
		return criteria.list();
	}
}

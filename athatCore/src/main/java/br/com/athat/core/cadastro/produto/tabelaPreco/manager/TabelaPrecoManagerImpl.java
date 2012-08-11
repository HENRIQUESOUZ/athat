package br.com.athat.core.cadastro.produto.tabelaPreco.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.cadastro.produto.tabelaPreco.entity.TabelaPreco;
import br.com.athat.core.manager.AbstractManager;
import br.com.athat.utils.validators.ValidatorUtils;

public class TabelaPrecoManagerImpl extends AbstractManager implements TabelaPrecoManager{

	private static final long serialVersionUID = 1L;

	@Transactional
	public void salvar(TabelaPreco tabelaPreco) {
		if(tabelaPreco != null)
			getEntityManager().persist(tabelaPreco);
		else
			getEntityManager().merge(tabelaPreco);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<TabelaPreco> buscar(TabelaPreco tabelaPreco) {
		Criteria criteria = createSession().createCriteria(TabelaPreco.class);
		
		if(ValidatorUtils.isNotEmptyAndNotNull(tabelaPreco.getNome()))
			criteria.add(Restrictions.like("nome", tabelaPreco.getNome(),MatchMode.START));
		
		if(tabelaPreco.getDataInicio() != null)
			criteria.add(Restrictions.eq("dataInicio", tabelaPreco.getDataInicio()));
		
		if(tabelaPreco.getDataFim() != null)
			criteria.add(Restrictions.eq("dataFim", tabelaPreco.getDataFim()));
		
		return criteria.list();
	}

	@Transactional(readOnly = true)
	public TabelaPreco buscarPorId(Long id) {
		return getEntityManager().find(TabelaPreco.class, id);
	}

}

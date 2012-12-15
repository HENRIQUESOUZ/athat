package br.com.athat.core.manager.produto.tabelaPreco;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.produto.tabelaPreco.TabelaPreco;
import br.com.athat.core.manager.AbstractManagerImpl;
import br.com.athat.utils.validators.ValidatorUtils;

public class TabelaPrecoManagerImpl extends AbstractManagerImpl implements TabelaPrecoManager{

	private static final long serialVersionUID = 1L;

	@Transactional
	@Override
	public void salvar(TabelaPreco tabelaPreco) {
		if(tabelaPreco != null)
			getEntityManager().persist(tabelaPreco);
		else
			getEntityManager().merge(tabelaPreco);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<TabelaPreco> buscar(TabelaPreco tabelaPreco) {
		Criteria criteria = createSession().createCriteria(TabelaPreco.class);
		
		if(ValidatorUtils.isNotEmptyAndNotNull(tabelaPreco.getNome()))
			criteria.add(Restrictions.like("nome", tabelaPreco.getNome(),MatchMode.START));
		
		if(tabelaPreco.getDataInicio() != null)
			criteria.add(Restrictions.le("dataInicio", tabelaPreco.getDataInicio()));
		
		if(tabelaPreco.getDataFim() != null)
			criteria.add(Restrictions.ge("dataFim", tabelaPreco.getDataFim()));
		
		return criteria.list();
	}

	@Transactional(readOnly = true)
	@Override
	public TabelaPreco buscarPorId(Long id) {
		return getEntityManager().find(TabelaPreco.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public TabelaPreco buscarTabelaVigente(Date data) {
		Criteria criteria = createSession().createCriteria(TabelaPreco.class)
			.add(Restrictions.le("dataInicio", data))
			.add(Restrictions.ge("dataFim",data))
			.addOrder(Order.asc("dataFim"))
		;
		List<TabelaPreco> tabelas = (List<TabelaPreco>) criteria.list();
		TabelaPreco tabelaPreco = null;
		if( tabelas != null && tabelas.size() > 1) {
			tabelaPreco = tabelas.get(0);
		}
		
		return tabelaPreco;
	}

}

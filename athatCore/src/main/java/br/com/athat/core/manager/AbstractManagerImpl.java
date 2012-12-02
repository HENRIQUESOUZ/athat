package br.com.athat.core.manager;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractManagerImpl implements Serializable {

    private static final long serialVersionUID = 1L;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager entityManager;

    protected Session createSession() {
    	return (Session)getEntityManager().getDelegate();
    }

    @Transactional(propagation= Propagation.MANDATORY)
    protected EntityManager getEntityManager() {
        return entityManager;
    }
    
    public <T> T buscarPorId(Class<T> classe, Long id) {
    	return entityManager.find(classe, id);
    }

}

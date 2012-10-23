package br.com.athat.core.security;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.usuario.Usuario;

public class HibernateUserDetailsService implements UserDetailsService, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional(readOnly = false)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

        if (username == null) {
            throw new UsernameNotFoundException("Usuário não encontrado.");
        }

        Session session = (Session)entityManager.getDelegate();
        Usuario usuario = getUser(username, session);

        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuário %s não encontrado.", username));
        }

        return usuario;
    }

    public Usuario getUser(String username,Session session) {
        Criteria criteria = session.createCriteria(Usuario.class)
                .add(Restrictions.eq("username",username));
        return (Usuario) criteria.uniqueResult();
    }


  
}

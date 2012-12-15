package br.com.athat.core.manager.usuario;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import br.com.athat.core.entity.usuario.Usuario;
import br.com.athat.core.manager.AbstractManagerImpl;

public class UsuarioManagerImpl extends AbstractManagerImpl implements UsuarioManager {

	private static final long serialVersionUID = 1L;

	public Usuario findByLogin(String login) {
        
        Criteria criteria = createSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("login", login))
        ;
        
        return (Usuario) criteria.uniqueResult();
    }

    public void createAdmin() {
        
//        Criteria criteria = createSession().createCriteria(Perfil.class)
//                .add(Restrictions.eq("descricao", "ROLE_ADMIN"));
//        
//        Perfil perfil = (Perfil) criteria.uniqueResult();
//
//        if (perfil == null) {
//            perfil = new Perfil();
//            perfil.setDescricao("ROLE_ADMIN");
//            getEntityManager().persist(perfil);
//
//            Usuario usuario = new Usuario();
//            usuario.setUsername("admin");
//            usuario.setName("admin");
//            usuario.setPassword(DigestUtils.sha512Hex("123"));
//            usuario.setEnabled(true);
//            getEntityManager().persist(usuario);
//
//            UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
//            usuarioPerfil.setUsuario(usuario);
//            usuarioPerfil.setPerfil(perfil);
//            getEntityManager().persist(usuarioPerfil);
//        }

    }

    @Override
    @Transactional
    public void salvar(Usuario usuario) {
        if(usuario.getId() == null) {
        	getEntityManager().persist(usuario);
        } else {
        	getEntityManager().merge(usuario);
        }
    }

	@Override
	@Transactional(readOnly = true)
	public Usuario login(String nome, String senha) {
		Criteria criteria = createSession().createCriteria(Usuario.class)
			.add(Restrictions.eq("username", nome))
			.add(Restrictions.eq("password", senha))
		;		
		return (Usuario) criteria.uniqueResult();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> buscar(String nome) {
		Criteria criteria = createSession().createCriteria(Usuario.class);
		
		if(nome != null && !nome.isEmpty()) {
			criteria.add(Restrictions.eq("username", nome));
		}
		
		return null;
	}
    
}

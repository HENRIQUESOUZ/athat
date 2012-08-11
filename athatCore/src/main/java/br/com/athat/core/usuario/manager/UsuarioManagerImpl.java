package br.com.athat.core.usuario.manager;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.athat.core.manager.AbstractManager;
import br.com.athat.core.usuario.entity.Perfil;
import br.com.athat.core.usuario.entity.Usuario;
import br.com.athat.core.usuario.entity.UsuarioPerfil;

public class UsuarioManagerImpl extends AbstractManager implements UsuarioManager{

	private static final long serialVersionUID = 1L;

	public Usuario findByLogin(String login) {
        
        Criteria criteria = createSession().createCriteria(Usuario.class)
                .add(Restrictions.eq("login", login))
        ;
        
        return (Usuario) criteria.uniqueResult();
    }

    public void createAdmin() {
        
        Criteria criteria = createSession().createCriteria(Perfil.class)
                .add(Restrictions.eq("descricao", "ROLE_ADMIN"));
        
        Perfil perfil = (Perfil) criteria.uniqueResult();

        if (perfil == null) {
            perfil = new Perfil();
            perfil.setDescricao("ROLE_ADMIN");
            getEntityManager().persist(perfil);

            Usuario usuario = new Usuario();
            usuario.setUsername("admin");
            usuario.setName("admin");
            usuario.setPassword(DigestUtils.sha512Hex("123"));
            usuario.setEnabled(true);
            getEntityManager().persist(usuario);

            UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
            usuarioPerfil.setUsuario(usuario);
            usuarioPerfil.setPerfil(perfil);
            getEntityManager().persist(usuarioPerfil);
        }

    }

    public void salvar(Usuario usuario) {
        
//        if (usuario.getId() == null) {
//                getEntityManager().persist(usuario);
//
//            UsuarioPerfil usuarioPerfil = new UsuarioPerfil();
//            usuarioPerfil.setUsuario(usuario);
//            usuarioPerfil.setPerfil(perfil);
//            getEntityManager().persist(usuarioPerfil);

//        } else {
//            if (usuario.isEnabled() == false) {
//                Criteria criteria = createSession().createCriteria(UsuarioPerfil.class)
//                        .add(Restrictions.eq("enabled", Boolean.TRUE));
//
//                List<UsuarioPerfil> usuarioGrandsList = criteria.list();
//                if (usuarioGrandsList.size() > 1) {
//                    getEntityManager().merge(usuario);
//                } else {
//                    throw new IllegalArgumentException("Usuário não pode ser desativado pois é o unico ativo");
//                }
//            } else {
//                getEntityManager().merge(usuario);
//            }
//        }

        
    }
    
}

package br.com.athat.core.security;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.athat.core.usuario.entity.Usuario;


public class AthatRevisionListener implements RevisionListener {

	public void newRevision(final Object revisionEntity) {
		AthatRevisionEntity athatRevisionEntity = (AthatRevisionEntity) revisionEntity;

		Date time = Calendar.getInstance().getTime();
		athatRevisionEntity.setDate(time);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			String currentUser = authentication.getName();
			Object entity = authentication.getPrincipal();
                        if (entity instanceof Usuario) {
                            entity = entity.getClass().getSimpleName();
                        }
			athatRevisionEntity.setUsername(currentUser);
			athatRevisionEntity.setEntity(entity.toString());
		} else {
			athatRevisionEntity.setUsername(String.format("SYSTEM:%d", time.getTime()));
		}

	}

}

package br.com.athat.core.usuario.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.athat.core.entity.AbstractEntity;

@Entity
public class Usuario extends AbstractEntity implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Column(length = 21, nullable = false)
    private String username;
    
    @Column(length = 130, nullable = false)
    private String password;
    
    @Column(length = 50, nullable = false)
    private String name;
    
    @Basic
    private boolean enabled = false;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UsuarioPerfil",
        joinColumns =   @JoinColumn(name = "usuario_fk"), inverseJoinColumns =
                        @JoinColumn(name = "perfil_fk"))
    private List<Perfil> perfis = new ArrayList<Perfil>();

    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        for (Perfil perfil : getPerfis()) {
            list.add(new GrantedAuthorityImpl(perfil.getAuthority()));
        }
        return list;
    }

    @Override
    public String toString() {
        return String.format("#%d %s", getId(), getUsername());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Usuario other = (Usuario) obj;
        if (username == null) {
            if (other.username != null) {
                return false;
            }
        } else if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }
}

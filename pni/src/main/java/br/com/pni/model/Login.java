package br.com.pni.model;

import java.util.Arrays;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tbl_login")
public class Login implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id")
	private Long id;

	@Column(name = "login")
	private String email;

	private String senha;

	private boolean ativo;

	@ManyToOne
	@JoinColumn(name = "nivel_id")
	private Nivel nivel;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection) Arrays.asList((Object[]) new Nivel[] { this.nivel });
	}

	public String getPassword() {
		return this.senha;
	}

	public String getUsername() {
		return this.email;
	}

	public boolean isAccountNonExpired() {
		return this.ativo;
	}

	public boolean isAccountNonLocked() {
		return this.ativo;
	}

	public boolean isCredentialsNonExpired() {
		return this.ativo;
	}

	public boolean isEnabled() {
		return this.ativo;
	}
}

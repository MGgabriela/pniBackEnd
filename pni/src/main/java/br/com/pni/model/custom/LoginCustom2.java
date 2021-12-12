package br.com.pni.model.custom;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_login")
public class LoginCustom2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment
	@Column(name = "login_id")
	private Long id;
	
	@Column(name = "login")
	private String email;	
	
	private String senha;	
	private String nome;

	@Column(name = "data_criacao")
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(name = "data_ultima_alteracao")
	private LocalDateTime dataUltimaAlteracao = LocalDateTime.now();

	@ManyToOne
	@JoinColumn(name = "nivel_id") 
	private NivelAdd nivel;
	
//	construtor de inserir
	public LoginCustom2(String email, String senha, String nome, NivelAdd nivel) {
		this.email = email;
		this.senha = senha;
		this.nivel = nivel;
		this.nome = nome;
	}

}

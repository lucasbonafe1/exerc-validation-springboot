package br.org.serratec.biblioteca.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "user_id",
		scope = Usuario.class
) // somente para eliminar o ciclo que acontece no codigo que fica um entrando dentro do outro na hora do get
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer user_id;
	
	@Column(name = "user_nome")
	@NotEmpty(message = "Nome não pode estar em branco.")
	private String user_nome;
	
	@Column(name = "user_email")
	@NotBlank(message = "Email não pode estar em branco.")
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	private String user_email;
	
	@Column(name = "user_password")
	@NotBlank(message = "Senha não pode estar em branco.")
	private String user_password;
	
	@ManyToOne
	@JoinColumn(name = "perfil_id", referencedColumnName = "perfil_id")
	private Perfil perfil;

	public Usuario() {

	}
	
	public Usuario(Integer user_id, String user_nome, String user_email, String user_password, Perfil perfil) {
		this.user_id = user_id;
		this.user_nome = user_nome;
		this.user_email = user_email;
		this.user_password = user_password;
		this.perfil = perfil;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_nome() {
		return user_nome;
	}

	public void setUser_nome(String user_nome) {
		this.user_nome = user_nome;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public Integer getPerfil() {
		return perfil.getPerfilId();
	}

	/*public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}*/
	
}


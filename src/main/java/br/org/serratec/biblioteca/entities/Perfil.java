package br.org.serratec.biblioteca.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity // define que a class é uma entidade
@Table(name = "perfil")
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "perfilId",
		scope = Perfil.class
)
public class Perfil {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "perfil_id")
	private Integer perfilId;
	
	
	@Column(name = "nome")
	@NotEmpty(message = "Nome não pode estar em branco")
	private String nome;
	
	
	@Column(name = "descricao")
	@NotNull
	private String descricao;

	@OneToMany(mappedBy = "perfil") // nome da instancia da classe perfil
	private List<Usuario> usuario; // para retornar uma lista de usuários que estão naquele determinado perfil

	public Perfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Perfil(Integer perfilId, String nome, String descricao) {
		super();
		this.perfilId = perfilId;
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "\n\nperfilId=" + perfilId + ", \nnome=" + nome + ", \ndescricao=" + descricao + "]";
	}
}

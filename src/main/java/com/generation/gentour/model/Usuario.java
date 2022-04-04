package com.generation.gentour.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5, max =50)
	private String emailUsuario;
	
	@NotNull
	@Size(min =8, max=30)
	private String senha;
	
	@NotNull
	@Size(min=4, max=60)
	private String nomeCompleto;
	
	@NotNull
	@Size(min=20, max=2500)
	private String dadosPessoais;
	
	@NotNull
	@Size(min=20, max = 100)
	private String dadosPagamento;
	
	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	private String foto;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(String dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public String getDadosPagamento() {
		return dadosPagamento;
	}

	public void setDadosPagamento(String dadosPagamento) {
		this.dadosPagamento = dadosPagamento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	

}

package com.generation.gentour.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Schema(example = "email@email.com.br")
	@NotNull(message = "O atributo Usuário é Obrigatório!")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	private String usuario;

	@NotNull
	@Size(min=8)
	private String senha;
	
	@Size(max = 80)
	private String nomeCompleto;
	
	@Size(max = 5000)
	private String foto;

	@Size(min=8, max=13)
	private String telefone;
	
	@Size(min=11 , max=14)
	private String identidade;

	@Size(max=8)
	private String cep;
	
	@Size(max=5)
	private String nCasa;
	
	@Size(max=10)
	private String refCasa;
	
	@Size(min=16,max=16)
	private String nCartao;
	
	@Size(min=6,max=6)
	private String validadeCartao;
	
	@Size(min=3, max=3)
	private String cvv;
	
	private String tipo;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produto;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getnCasa() {
		return nCasa;
	}

	public void setnCasa(String nCasa) {
		this.nCasa = nCasa;
	}

	public String getRefCasa() {
		return refCasa;
	}

	public void setRefCasa(String refCasa) {
		this.refCasa = refCasa;
	}

	public String getnCartao() {
		return nCartao;
	}

	public void setnCartao(String nCartao) {
		this.nCartao = nCartao;
	}

	public String getValidadeCartao() {
		return validadeCartao;
	}

	public void setValidadeCartao(String validadeCartao) {
		this.validadeCartao = validadeCartao;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	

	
}

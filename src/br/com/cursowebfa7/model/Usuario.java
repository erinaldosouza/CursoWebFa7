package br.com.cursowebfa7.model;

import java.util.Date;

public class Usuario {
	private String cpf;
	private String senha;
	private String nome;
	private String email;
	private Date dataNascimento;
	private Cep cep;
	private String marcador;
	private String jogadas;
	
	public Usuario(String cpf, String senha, String nome, String email, Date dataNascimento, Cep cep) {
		this();
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.cep = cep;
	}

	public Usuario() {
		jogadas = new String();
	}

	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	
	
	public String getDadosAcesso() {
		return cpf+senha;
	}

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public String getMarcador() {
		return marcador;
	}

	public void setMarcador(String marcador) {
		this.marcador = marcador;
	}

	public String getJogadas() {
		return jogadas;
	}

	public void setJogadas(String jogadas) {
		this.jogadas = jogadas;
	}
	
}
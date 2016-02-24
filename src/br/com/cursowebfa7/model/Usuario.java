package br.com.cursowebfa7.model;

public class Usuario {
	private String cpf;
	private String senha;
	private String nome;
	
	public Usuario(String cpf, String senha, String nome) {
		this.cpf = cpf;
		this.senha = senha;
		this.nome = nome;
	}

	public Usuario() {
	}

	public String getNome() {
		return nome;
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
}
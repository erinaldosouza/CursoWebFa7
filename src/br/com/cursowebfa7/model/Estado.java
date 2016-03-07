package br.com.cursowebfa7.model;

import java.util.List;


public class Estado {

	private Long id;
	private String nome;
	private String sigla;
	private List<Cidade> cidades;
	
	public Estado(long id, String estado, String sigla) {
		this.id = id;
		this.nome = estado;
		this.sigla = sigla;
	}
	
	public Estado() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
}
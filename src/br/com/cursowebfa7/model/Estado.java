package br.com.cursowebfa7.model;

import java.util.Date;


public class Estado {

	private Long id;
	private String nome;
	private String sigla;
	private Date dataConstituicao;
	private Long populacao;
	private Double pib;
	
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

	public Date getDataConstituicao() {
		return dataConstituicao;
	}

	public void setDataConstituicao(Date dataConstituicao) {
		this.dataConstituicao = dataConstituicao;
	}

	public Long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}

	public Double getPib() {
		return pib;
	}

	public void setPib(Double pib) {
		this.pib = pib;
	}
}
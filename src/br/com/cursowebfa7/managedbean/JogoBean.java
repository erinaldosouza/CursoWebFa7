package br.com.cursowebfa7.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cursowebfa7.model.Usuario;

@ManagedBean
@ViewScoped
public class JogoBean {

	private Usuario jogadorUm = new Usuario();
	private Usuario jogadorDois = new Usuario();
	private Usuario jogadorDaVez;
		
	
	public void iniciar() {
		jogadorUm.setMarcador("X");
		jogadorDois.setMarcador("O");
		jogadorDaVez = jogadorUm;
	}
	
	
	public void jogar() {
		if(jogadorDaVez == jogadorUm) {
			jogadorDaVez = jogadorDois;
		} else {
			jogadorDaVez = jogadorUm;
		}
	}
	public Usuario getJogadorUm() {
		return jogadorUm;
	}
	public void setJogadorUm(Usuario jogadorUm) {
		this.jogadorUm = jogadorUm;
	}
	public Usuario getJogadorDois() {
		return jogadorDois;
	}
	public void setJogadorDois(Usuario jogadorDois) {
		this.jogadorDois = jogadorDois;
	}

	public Usuario getJogadorDaVez() {
		return jogadorDaVez;
	}

	public void setJogadorDaVez(Usuario jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
	}	
}
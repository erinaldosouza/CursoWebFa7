package br.com.cursowebfa7.managedbean;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.cursowebfa7.model.Usuario;

@ManagedBean
@ViewScoped
public class JogoBean {

	private Boolean btnDisabled = Boolean.TRUE;
	private Usuario jogadorUm = new Usuario();
	private Usuario jogadorDois = new Usuario();
	private Usuario jogadorDaVez;
	private String marcar = null;
    private Boolean isOver = Boolean.FALSE;
  
    private static final String[] vitoria = {"1\\d*2\\d*3", "4\\d*5\\d*6", "7\\d*8\\d*9", "1\\d*4\\d*7", "2\\d*5\\d*8", "3\\d*6\\d*9", "1\\d*5\\d*9", "3\\d*5\\d*7"};
    
	
	public void iniciar() {
		
		jogadorUm.setMarcador("X");
		jogadorUm.setJogadas("");
		jogadorDois.setMarcador("O");
		jogadorDois.setJogadas("");
		jogadorDaVez = jogadorUm;
   		marcar = null;
		btnDisabled = false;
		isOver = false;
		
		if((int) Math.round(Math.random() * 2) % 2 == 0){
			jogadorDaVez=jogadorUm;
		} else {
			jogadorDaVez=jogadorDois;
		}
	}

	public void jogar(AjaxBehaviorEvent  event) { 
		if(Boolean.FALSE.equals(isOver) && jogadorDaVez != null) {
			event.getComponent().getAttributes().put("disabled", true);
			btnDisabled = true;
			jogadorDaVez.setJogadas(jogadorDaVez.getJogadas() + event.getComponent().getId().replaceAll("\\D", ""));
			marcar = jogadorDaVez.getMarcador();
			
			if(Boolean.FALSE.equals((isOver = check()))) {
				
				if(jogadorDaVez == jogadorUm) {
					jogadorDaVez = jogadorDois;
				} else {
					jogadorDaVez = jogadorUm;
				}
			}
		} else {
			marcar = "";
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


	public String getMarcar() {
		return marcar;
	}

	public void setMarcar(String marcar) {
		this.marcar = marcar;
	}

	public Boolean getIsOver() {
		return isOver;
	}
	
	public void setIsOver(Boolean isOver) {
		this.isOver = isOver;
	}
	
	public Boolean check() {
		
		Pattern patter = null;
		Matcher matcher = null;
		
		for (String vit : vitoria) {
			char[] chars = jogadorDaVez.getJogadas().toCharArray();
			Arrays.sort(chars);
			patter = Pattern.compile("\\d*" + vit + "\\d*");
			
			matcher = patter.matcher(new String(chars));
			
			if(isOver = matcher.find()) {
				break;
			}
		}
		
		if(isOver == false && new Integer(9).equals(jogadorUm.getJogadas().length() + jogadorDois.getJogadas().length())) {
			isOver = null;
		}
		return isOver;
	}

	public Boolean getBtnDisabled() {
		return btnDisabled;
	}

	public void setBtnDisabled(Boolean btnDisabled) {
		this.btnDisabled = btnDisabled;
	}
}
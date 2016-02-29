package br.com.cursowebfa7.managedbean;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
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
    
    private UIComponent btn1;
    private UIComponent btn2;
    private UIComponent btn3;
    private UIComponent btn4;
    private UIComponent btn5;
    private UIComponent btn6;
    private UIComponent btn7;
    private UIComponent btn8;
    private UIComponent btn9;
  
    private static final String[] vitoria = {"1\\d*2\\d*3", "4\\d*5\\d*6", "7\\d*8\\d*9", "1\\d*4\\d*7", "2\\d*5\\d*8", "3\\d*6\\d*9", "1\\d*5\\d*9", "3\\d*5\\d*7"};
    
	
	public void iniciar() {
		UIComponent[] btns = new UIComponent[]{btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9};
		for (UIComponent btn : btns) {
			btn.getAttributes().put("disabled", false);
		}
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

	public UIComponent getBtn1() {
		return btn1;
	}

	public void setBtn1(UIComponent btn1) {
		this.btn1 = btn1;
	}

	public UIComponent getBtn2() {
		return btn2;
	}

	public void setBtn2(UIComponent btn2) {
		this.btn2 = btn2;
	}

	public UIComponent getBtn3() {
		return btn3;
	}

	public void setBtn3(UIComponent btn3) {
		this.btn3 = btn3;
	}

	public UIComponent getBtn4() {
		return btn4;
	}

	public void setBtn4(UIComponent btn4) {
		this.btn4 = btn4;
	}

	public UIComponent getBtn5() {
		return btn5;
	}

	public void setBtn5(UIComponent btn5) {
		this.btn5 = btn5;
	}

	public UIComponent getBtn6() {
		return btn6;
	}

	public void setBtn6(UIComponent btn6) {
		this.btn6 = btn6;
	}

	public UIComponent getBtn7() {
		return btn7;
	}

	public void setBtn7(UIComponent btn7) {
		this.btn7 = btn7;
	}

	public UIComponent getBtn8() {
		return btn8;
	}

	public void setBtn8(UIComponent btn8) {
		this.btn8 = btn8;
	}

	public UIComponent getBtn9() {
		return btn9;
	}

	public void setBtn9(UIComponent btn9) {
		this.btn9 = btn9;
	}
}
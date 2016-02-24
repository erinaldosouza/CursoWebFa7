package br.com.cursowebfa7.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.cursowebfa7.listener.AppListener;
import br.com.cursowebfa7.model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	
	@ManagedProperty(value="#{sessionBean}")
	private SessionBean sessionBean;
	
	private String mensagens;
	
	public String login() {
		String page = "index";
		usuario = AppListener.usuariosMap.get(usuario.getCpf());
		if(usuario == null) {
			page = "login";
			mensagens = "dados.acesso.invalidos";
		} else {
			mensagens = "bem.vindo";
			sessionBean.setIsLogged(true);
		}
		
		return page;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensagens() {
		return mensagens;
	}

	public void setMensagens(String mensagens) {
		this.mensagens = mensagens;
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
}
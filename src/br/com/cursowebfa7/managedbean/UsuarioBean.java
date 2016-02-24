package br.com.cursowebfa7.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.cursowebfa7.model.Usuario;
import br.com.cursowebfaz.business.UsuarioBusiness;

@ManagedBean
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	
	@ManagedProperty(value="#{sessionBean}")
	private SessionBean sessionBean;
	
	@ManagedProperty(value="#{usuarioBusiness}")
	private UsuarioBusiness usuarioBusiness;
	
	private String mensagens;
	
	public String login() {
		String page = "index";
		usuario = usuarioBusiness.login(usuario.getDadosAcesso());
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

	public UsuarioBusiness getUsuarioBusiness() {
		return usuarioBusiness;
	}

	public void setUsuarioBusiness(UsuarioBusiness usuarioBusiness) {
		this.usuarioBusiness = usuarioBusiness;
	}
}
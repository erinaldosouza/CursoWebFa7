package br.com.cursowebfa7.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.cursowebfa7.model.Usuario;
import br.com.cursowebfaz.business.UsuarioBusiness;
import br.com.cursowebfaz.exception.UsuarioInvalidoException;

@ManagedBean
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	
	@ManagedProperty(value="#{sessionBean}")
	private SessionBean sessionBean;
	
	@ManagedProperty(value="#{usuarioBusiness}")
	private UsuarioBusiness usuarioBusiness;
	
	public String login() {
		String page = "index";
		
		
		try {
			usuario = usuarioBusiness.login(usuario.getDadosAcesso());
			sessionBean.setIsLogged(true);
		
		} catch (UsuarioInvalidoException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			String text  = context.getApplication()
					       .evaluateExpressionGet(context, "#{msg['" + e.getMessage() +"']}", String.class);

			FacesMessage mensagem = new FacesMessage();
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			mensagem.setSummary(text);
			context.addMessage(null, mensagem);
			page = null;
		}
		
		return page;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
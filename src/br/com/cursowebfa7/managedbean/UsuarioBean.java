package br.com.cursowebfa7.managedbean;

import java.util.List;

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
	

	/**
	 * realiza o login do usuário
	 * @author erinaldo.souza
	 * 
	 * @return usuário
	 */
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

	public String salvar() {
		usuarioBusiness.salvar(usuario);
		return "listaUsuarios";
	}

	public String excluir() {
		usuarioBusiness.excluir(usuario);
		return null;
	}
	
	public List<Usuario> getLista() {
		return usuarioBusiness.getLista();
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
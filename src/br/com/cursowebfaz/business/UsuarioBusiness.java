package br.com.cursowebfaz.business;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.cursowebfa7.filtro.UsuarioDao;
import br.com.cursowebfa7.model.Usuario;
import br.com.cursowebfaz.exception.UsuarioInvalidoException;

@ManagedBean
@RequestScoped
public class UsuarioBusiness {

	@ManagedProperty(value="#{usuarioDao}")
	UsuarioDao usuarioDao;
	
	Usuario usuario;
	
	public Usuario login(String acesso) throws UsuarioInvalidoException {
		usuario = usuarioDao.login(acesso);
		
		if(usuario == null) {
			throw new UsuarioInvalidoException("dados.acesso.invalido");
		}
		
		return usuario;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
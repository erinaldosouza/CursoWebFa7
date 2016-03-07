package br.com.cursowebfa7.business;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.cursowebfa7.dao.UsuarioDao;
import br.com.cursowebfa7.exception.UsuarioInvalidoException;
import br.com.cursowebfa7.model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioBusiness {

	@ManagedProperty(value="#{usuarioDao}")
	UsuarioDao usuarioDao;
	
	Usuario usuario;
	
	/**
	 * Retorna um usuário com base nos dados de acesso
	 * @author erinaldo.souza
	 * 
	 * @param acesso
	 * @return usuário
	 * @throws UsuarioInvalidoException
	 */
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

	/**
	 * Monta a lista e usuários
	 * @author erinaldo.souza
	 * 
	 * @return
	 */
	public List<Usuario> getLista() {
	
		return usuarioDao.listar();
	}

	/**
	 * Remove um usuário do "banco"
	 * @author erinaldo.souza
	 * 
	 * @param usuario
	 */
	public String excluir(Usuario usuario) {
		usuarioDao.remove(usuario);
		return null;
	}

	/**
	 * Insere no "banco" um novo usuário ou um usuário editado
	 * @author erinaldo.souza
	 *  
	 * @param user
	 */
	public void salvar(Usuario user) {
		usuarioDao.salvar(user);
	}
}
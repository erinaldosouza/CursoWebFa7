package br.com.cursowebfaz.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.cursowebfa7.filtro.UsuarioDao;
import br.com.cursowebfa7.listener.AppListener;
import br.com.cursowebfa7.model.Usuario;
import br.com.cursowebfaz.exception.UsuarioInvalidoException;

@ManagedBean
@RequestScoped
public class UsuarioBusiness {

	@ManagedProperty(value="#{usuarioDao}")
	UsuarioDao usuarioDao;
	
	Usuario usuario;
	
	/**
	 * Retorna um usu�rio com base nos dados de acesso
	 * @author erinaldo.souza
	 * 
	 * @param acesso
	 * @return usu�rio
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
	 * Monta a lista e usu�rios
	 * @author erinaldo.souza
	 * 
	 * @return
	 */
	public List<Usuario> getLista() {
		List<Usuario> usuarios = new ArrayList<>();
		
		for (Entry<String, br.com.cursowebfa7.model.Usuario> usuario : AppListener.usuariosMap.entrySet()) {
			usuarios.add((Usuario) usuario.getValue());
		}
		
		return usuarios;
	}

	/**
	 * Remove um usu�rio do "banco"
	 * @author erinaldo.souza
	 * 
	 * @param usuario
	 */
	public void excluir(Usuario usuario) {
		AppListener.usuariosMap.remove(usuario.getDadosAcesso());
	}
}
package br.com.cursowebfa7.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.cursowebfa7.listener.AppListener;
import br.com.cursowebfa7.model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioDao {

	public Usuario login(String acesso) {
		return AppListener.usuariosMap.get(acesso);
	}

	public void remove(Usuario usuario) {
		AppListener.usuariosMap.remove(usuario.getDadosAcesso());		
	}

	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<>();
		
		for (Entry<String, br.com.cursowebfa7.model.Usuario> usuario : AppListener.usuariosMap.entrySet()) {
			usuarios.add((Usuario) usuario.getValue());
		}
		
		return usuarios;
	}

	public void salvar(Usuario user) {
		AppListener.usuariosMap.put(user.getDadosAcesso(), user);
	}

}

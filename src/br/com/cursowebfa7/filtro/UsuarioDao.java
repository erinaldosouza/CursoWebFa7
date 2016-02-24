package br.com.cursowebfa7.filtro;

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

}

package br.com.cursowebfaz.business;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.cursowebfa7.dao.EstadoDao;
import br.com.cursowebfa7.model.Cidade;
import br.com.cursowebfa7.model.Estado;

@ManagedBean
@RequestScoped
public class EstadoBusiness {

	@ManagedProperty(value="#{estadoDao}")
	private EstadoDao estadoDao;
	
	public List<Estado> getLista() {
		return estadoDao.getLista();
	}

	public EstadoDao getEstadoDao() {
		return estadoDao;
	}

	public void setEstadoDao(EstadoDao estadoDao) {
		this.estadoDao = estadoDao;
	}

	public Estado getEstado(Estado estado) {
		return estadoDao.getEstado(estado);
	}

	public void editEstado(Estado estado) {
		estadoDao.editEstdo(estado);		
	}

	public Cidade getCidade(Cidade cidade) {
		if(cidade.getId() != null) {
			return estadoDao.getCidade(cidade);
		}
		
		return null;
	}	
}
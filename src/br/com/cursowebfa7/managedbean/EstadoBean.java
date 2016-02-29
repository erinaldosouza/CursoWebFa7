package br.com.cursowebfa7.managedbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.cursowebfa7.model.Estado;
import br.com.cursowebfaz.business.EstadoBusiness;

@ManagedBean
@RequestScoped
public class EstadoBean {
	private Estado estado = new Estado();
	@ManagedProperty(value="#{estadoBusiness}")
	private EstadoBusiness estadoBusiness;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}	
	
	public String editar() {
		return "editarEstado";
	}
	
	public List<Estado> getLista() {
		return estadoBusiness.getLista();
	}

	public EstadoBusiness getEstadoBusiness() {
		return estadoBusiness;
	}

	public void setEstadoBusiness(EstadoBusiness estadoBusiness) {
		this.estadoBusiness = estadoBusiness;
	}
}
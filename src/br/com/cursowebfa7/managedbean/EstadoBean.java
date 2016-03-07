package br.com.cursowebfa7.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.cursowebfa7.model.Cidade;
import br.com.cursowebfa7.model.Estado;
import br.com.cursowebfaz.business.EstadoBusiness;

@ManagedBean
@RequestScoped
public class EstadoBean {
	private Estado estado = new Estado();
	private Cidade cidade = new Cidade();
	
	@ManagedProperty(value="#{estadoBusiness}")
	private EstadoBusiness estadoBusiness;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}	
	
	public String editar() {
		estado = estadoBusiness.getEstado(estado);
		return "editarEstado";
	}
	
	public String excluirCidade() {
		System.out.println("Dã");
		return "listaEstados";
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public void exibir() {
		estado = estadoBusiness.getEstado(estado);
	}
	
	public void exibirCidade() {
		if(cidade.getId() != null) {
			cidade = estadoBusiness.getCidade(cidade);
		}
	}
	
	public String salvarCidade() {
		exibir();
		if(estado != null && estado.getCidades() == null || estado.getCidades().isEmpty()) {
			estado.setCidades(new ArrayList<Cidade>(10));
			estado.getCidades().add(null);
			estado.getCidades().add(null);
			estado.getCidades().add(null);
			cidade.setId(0l);
		}
		
		if(cidade.getId() == null) {
			int listSize = estado.getCidades().size();
			if(listSize == 0) {
				listSize++;
			}
			cidade.setId(Long.valueOf(listSize));
		}
			
		estado.getCidades().set(cidade.getId().intValue(), cidade);
		estadoBusiness.editEstado(estado);
		
		return "listarEstados";
	}
}
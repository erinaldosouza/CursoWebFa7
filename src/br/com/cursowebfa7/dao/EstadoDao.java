package br.com.cursowebfa7.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.cursowebfa7.listener.AppListener;
import br.com.cursowebfa7.model.Cidade;
import br.com.cursowebfa7.model.Estado;

@ManagedBean
@RequestScoped
public class EstadoDao {

	public List<Estado> getLista() {
		List<Estado> estados  = new ArrayList<Estado>();
		for (Entry<Long, Estado> estado : AppListener.estadosMap.entrySet()) {
			estados.add(estado.getValue());
		}
		return estados;
	}

	public Estado getEstado(Estado estado) {
		return AppListener.estadosMap.get(estado.getId());
	}

	public void editEstdo(Estado estado) {
		AppListener.estadosMap.put(estado.getId(), estado);
	}

	public Cidade getCidade(Cidade cidade) {
		Cidade city = null;
		List<Estado> estados = getLista();
		for (Estado estado : estados) {
			for (Cidade c : estado.getCidades()) {
				if(c.getId().equals(cidade.getId()))
					city = c;
				break;
			}
			break;
		}
		return city;
	}
}

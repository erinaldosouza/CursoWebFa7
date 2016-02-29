package br.com.cursowebfa7.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.cursowebfa7.listener.AppListener;
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
}

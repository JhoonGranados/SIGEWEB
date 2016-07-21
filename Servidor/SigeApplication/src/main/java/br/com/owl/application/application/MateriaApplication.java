package br.com.owl.application.application;

import java.util.ArrayList;
import java.util.List;

import br.com.owl.dominio.enuns.Materia;

public class MateriaApplication {

	public List<String> buscarMaterias() {
		List<String> listaMaterias = new ArrayList<String>();
		
		listaMaterias.add(Materia.BIOLOGIA.toString());
		listaMaterias.add(Materia.FISICA.toString());
		listaMaterias.add(Materia.GEOGRAFIA.toString());
		listaMaterias.add(Materia.HISTORIA.toString());
		listaMaterias.add(Materia.MATEMATICA.toString());
		listaMaterias.add(Materia.PORTUGUES.toString());
		listaMaterias.add(Materia.QUIMICA.toString());
		
		return listaMaterias;
	}

}

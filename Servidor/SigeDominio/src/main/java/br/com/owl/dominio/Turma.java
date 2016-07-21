package br.com.owl.dominio;

import java.util.ArrayList;
import java.util.List;

import br.com.owl.dominio.enuns.Serie;

public class Turma {
	
	private List<Disciplina> disciplinas;
	private Serie serie;
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public List<String> getSeriesDisponiveis() {
		List<String> listaSeries = new ArrayList<String>();
		listaSeries.add("1 - "+ getSerie().PRIMEIRO_ANO.toString());
		listaSeries.add("2 - "+ getSerie().SEGUNDO_ANO.toString());
		listaSeries.add("3 - "+ getSerie().TERCEIRO_ANO.toString());
		return listaSeries;
	}
}


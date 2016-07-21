package br.com.owl.dominio;

import br.com.owl.dominio.enuns.Materia;
import br.com.owl.dominio.enuns.Serie;

public class Tarefa {
	
	private Serie serie;
	private Materia materia;
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}

package br.com.owl.dominio;

import br.com.owl.dominio.enuns.Materia;

public class Disciplina {
	private Double nota;
	private Double faltas;
	private Materia materia;
	
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	public Double getFaltas() {
		return faltas;
	}
	public void setFaltas(Double faltas) {
		this.faltas = faltas;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}

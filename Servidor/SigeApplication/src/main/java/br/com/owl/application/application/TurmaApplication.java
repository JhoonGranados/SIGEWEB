package br.com.owl.application.application;

import java.util.List;

import br.com.owl.dominio.Turma;

public class TurmaApplication {

	public List<String> buscarSeries() {
		return new Turma().getSeriesDisponiveis();
	}
}

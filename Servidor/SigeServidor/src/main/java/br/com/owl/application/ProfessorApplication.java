package br.com.owl.application;

import com.google.gson.Gson;

import br.com.owl.dominio.interfaces.IRepositorio;
import br.com.owl.entity.ProfessorEntity;
import br.com.owl.repository.ProfessorDao;

public class ProfessorApplication {
	private IRepositorio repositorioProfessor;
	
	public ProfessorApplication() {
		this.repositorioProfessor = new ProfessorDao();
	}
	
	public String buscar() {
		return new Gson().toJson(this.repositorioProfessor.buscar());
	}
	
	public String buscar(int id) {
		return new Gson().toJson(this.repositorioProfessor.buscar(id));
	}
	
	public void salvar(String conteudo) {
		ProfessorEntity entidade = new Gson().fromJson(conteudo, ProfessorEntity.class);
		this.repositorioProfessor.salvar(entidade);
	}
}

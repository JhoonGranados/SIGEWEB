package br.com.owl.application;

import java.util.List;

import com.google.gson.Gson;

import br.com.owl.dominio.Aluno;
import br.com.owl.dominio.dto.AlunoDto;
import br.com.owl.dominio.exceptions.InvalideAttributExeception;
import br.com.owl.dominio.interfaces.IRepositorio;
import br.com.owl.entity.AlunoEntity;
import br.com.owl.entity.Entidade;
import br.com.owl.repository.AlunoRepository;

public class AlunoApplication {
	
	private IRepositorio repositorioAluno;
	
	public AlunoApplication() {
		repositorioAluno = new AlunoRepository();
	}

	public String buscarAlunos(){
		List<Entidade> listaAlunos = repositorioAluno.buscar();
		try {
			String dados = new Gson().toJson(listaAlunos);
			return dados;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public String buscarAlunos(int id){
		Entidade aluno = repositorioAluno.buscar(id);
		return new Gson().toJson(aluno);
	}
	
	public void salvar(String aluno){
		try {
			AlunoDto alunoDto = new Gson().fromJson(aluno, AlunoDto.class);
			Aluno dominio = new Aluno();
			dominio.validarAluno(alunoDto);
			AlunoEntity alunoEntity = dominio.converter();
			repositorioAluno.salvar(new Gson().fromJson(aluno, AlunoEntity.class));
		} catch (InvalideAttributExeception e) {
			
		} catch (Exception e) {
			
		}
	}
}

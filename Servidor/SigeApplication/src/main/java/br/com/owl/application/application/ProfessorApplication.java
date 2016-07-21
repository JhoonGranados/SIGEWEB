package br.com.owl.application.application;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.owl.application.conversor.ProfessorConverter;
import br.com.owl.application.dto.ProfessorForm;
import br.com.owl.application.dto.TarefaForm;
import br.com.owl.dominio.Professor;
import br.com.owl.infraestrutura.entity.ProfessorEntity;
import br.com.owl.infraestrutura.fabricas.ConnectionFactory;
import br.com.owl.infraestrutura.repository.ProfessorRepository;

public class ProfessorApplication {

	public boolean salvar(ProfessorForm professorForm) {
		
		EntityManager em = new ConnectionFactory().getEntityManeger();
		professorForm.setMatricula(new Professor().gerarMatricula());
		ProfessorEntity professorEntity = new ProfessorConverter().toEntity(professorForm);
		
		em.getTransaction().begin();
		boolean status  = new ProfessorRepository(em).salvar(professorEntity);
		em.getTransaction().commit();
		return status;
	}

	public List<ProfessorForm> buscar() {
		List<ProfessorEntity> professoresEntity = new ProfessorRepository(new ConnectionFactory().getEntityManeger()).buscar();
		List<ProfessorForm> professoresForm 	= new ProfessorConverter().toForm(professoresEntity);
		return professoresForm;
	}

	public boolean salvarTarefa(TarefaForm tarefaForm) {
		return true;
	}

	public List<TarefaForm> buscarTarefas() {
		return null;
	}

	public ProfessorForm buscar(int id) {
		ProfessorEntity professorEntity = new ProfessorRepository(new ConnectionFactory().getEntityManeger()).buscarPorMatricula(id);
		ProfessorForm professorForm 	= new ProfessorConverter().toForm(professorEntity);
		return professorForm;
	}
	
	public boolean remover(int id){
		EntityManager em = new ConnectionFactory().getEntityManeger();
		em.getTransaction().begin();
		boolean status = new ProfessorRepository(em).remover(id);
		em.getTransaction().commit();
		return status;
	}
}

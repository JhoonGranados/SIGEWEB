package br.com.owl.infraestrutura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.owl.infraestrutura.entity.AlunoEntity;
import br.com.owl.infraestrutura.entity.ProfessorEntity;
import br.com.owl.infraestrutura.entity.TarefasEntity;

public class ProfessorRepository {
	
	EntityManager entityManager;
	public ProfessorRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean salvar(ProfessorEntity professorEntity) {
		this.entityManager.persist(professorEntity);
		return true;
	}

	public List<ProfessorEntity> buscar() {
		Query query = entityManager.createQuery("select a from ProfessorEntity a");
		return query.getResultList();
	}
	
	public ProfessorEntity buscar(int id){
		Query query = entityManager.createQuery("select a from ProfessorEntity a where id = :id");
		query.setParameter("id", id);
		List<ProfessorEntity> lista = query.getResultList();
		if (lista != null) {
			return lista.get(0);
		}
		return null;
	}
	
	public ProfessorEntity buscarPorMatricula(int matricula) {
		Query query = entityManager.createQuery("select a from ProfessorEntity a where matricula = :matricula");
		query.setParameter("matricula", matricula);
		List<ProfessorEntity> lista = query.getResultList();
		if (lista != null) {
			return lista.get(0);
		}
		return null;
	}

	public boolean salvarTarefa(TarefasEntity tarefaEntity) {
		return false;
	}

	public List<TarefasEntity> buscarTarefas() {
		return null;
	}

	public boolean remover(int id) {
		ProfessorEntity professor = buscarPorMatricula(id);
		if (professor != null ) {
			this.entityManager.remove(professor);
			return true;
		}
		return false;
	}
}

package br.com.owl.infraestrutura.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.owl.infraestrutura.entity.AlunoEntity;
import br.com.owl.infraestrutura.entity.TarefasEntity;

public class AlunoRepository {
	
	EntityManager entityManager;
	
	public AlunoRepository(EntityManager entityManeger) {
		this.entityManager = entityManeger;
	}

	public void salvar(AlunoEntity alunoEntity) {
		this.entityManager.persist(alunoEntity);
	}

	public List<AlunoEntity> buscar() {
		Query query = entityManager.createQuery("select a from AlunoEntity a");
		return query.getResultList();
	}
	

// Query query = manager.createQuery("select pf from PessoaFisica pf where pf.nome like'" + nome + " %'");

	public List<AlunoEntity> buscar(String filtro) {
		Query query = entityManager.createQuery("select a from AlunoEntity a where a.nome like :filtro");
		query.setParameter("filtro", filtro);
		List<AlunoEntity> lista = query.getResultList();
		if (lista != null) {
			return lista;
		}
		return null;
	}

	public AlunoEntity buscar(int id) {
		Query query = entityManager.createQuery("select a from AlunoEntity a where id = :id");
		query.setParameter("id", id);
		List<AlunoEntity> lista = query.getResultList();
		if (lista != null) {
			return lista.get(0);
		}
		return null;
	}
	
	public AlunoEntity buscarPorMatricula(int matricula){
		Query query = entityManager.createQuery("select a from AlunoEntity a where matricula = :matricula");
		query.setParameter("matricula", matricula);
		List<AlunoEntity> lista = query.getResultList();
		if (lista != null) {
			return lista.get(0);
		}
		return null;
	}

	public boolean remover(int id) {
		AlunoEntity aluno = buscarPorMatricula(id);
		if (aluno != null ) {
			this.entityManager.remove(aluno);
			return true;
		}
		return false;
	}

	public List<TarefasEntity> buscarTarefas(int id) {
		return null;
	}

	public boolean editar(AlunoEntity alunoEntity) {
		AlunoEntity aluno = buscarPorMatricula(alunoEntity.getMatricula());
		
		aluno.setNome(alunoEntity.getNome());
		aluno.setSobrenome(alunoEntity.getSobrenome());
		aluno.setNomeMae(alunoEntity.getNomeMae());
		aluno.setNomePai(alunoEntity.getNomePai());
		aluno.setTelefone(alunoEntity.getTelefone());
		aluno.setEmail(alunoEntity.getEmail());
		aluno.setTurma(alunoEntity.getTurma());
		aluno.setDataNascimento(alunoEntity.getDataNascimento());
		
		return true;
	}
}

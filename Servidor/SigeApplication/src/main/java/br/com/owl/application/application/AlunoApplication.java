package br.com.owl.application.application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import br.com.owl.application.conversor.AlunoConverter;
import br.com.owl.application.dto.AlunoForm;
import br.com.owl.application.dto.TarefaForm;
import br.com.owl.dominio.Aluno;
import br.com.owl.infraestrutura.entity.AlunoEntity;
import br.com.owl.infraestrutura.entity.TarefasEntity;
import br.com.owl.infraestrutura.fabricas.ConnectionFactory;
import br.com.owl.infraestrutura.repository.AlunoRepository;

public class AlunoApplication {

	public void salvar(AlunoForm alunoForm) {
		alunoForm.setMatricula(new Aluno().gerarMatricula());
		AlunoEntity alunoEntity = new AlunoConverter().toEntity(alunoForm);
		/**
		 * Quem deve validar as entradas? 
		 * e qual classe de modelo será passada como parametro?
		 */
		EntityManager em = new ConnectionFactory().getEntityManeger();
		em.getTransaction().begin();
		new AlunoRepository(em).salvar(alunoEntity);
		em.getTransaction().commit();
	}

	public List<AlunoForm> buscarAlunos() {
		List<AlunoEntity> listaAlunoEntity 	= new AlunoRepository(new ConnectionFactory().getEntityManeger()).buscar();
		List<AlunoForm> listaAlunoForm 		= new AlunoConverter().toForm(listaAlunoEntity);
		return listaAlunoForm;
	}

	public AlunoForm buscarAlunos(int id) {
		AlunoEntity alunoEntity = new AlunoRepository(new ConnectionFactory().getEntityManeger()).buscarPorMatricula(id);
		AlunoForm alunoForm 	= new AlunoConverter().toForm(alunoEntity);
		return alunoForm;
	}

	public boolean remover(int id) {
		EntityManager em = new ConnectionFactory().getEntityManeger();
		em.getTransaction().begin();
		boolean status = new AlunoRepository(em).remover(id);
		em.getTransaction().commit();
		return status;
	}

	public List<TarefaForm> buscarTarefas(int id) {
		List<TarefasEntity> listaTarefasEntity 	= new AlunoRepository(new ConnectionFactory().getEntityManeger()).buscarTarefas(id);
		List<TarefaForm> listaTarefasForm 		= new AlunoConverter().tarefasToForm(listaTarefasEntity);
		return listaTarefasForm;
	}

	public List<AlunoForm> buscarAlunos(String filtro) {
		List<AlunoEntity> listaAlunoEntity 	= new AlunoRepository(new ConnectionFactory().getEntityManeger()).buscar(filtro);
		List<AlunoForm> listaAlunoForm 		= new AlunoConverter().toForm(listaAlunoEntity);
		return listaAlunoForm;
	}

	public void editar(AlunoForm alunoForm) {
		AlunoEntity alunoEntity = new AlunoConverter().toEntity(alunoForm);
		/**
		 * Quem deve validar as entradas? 
		 * e qual classe de modelo será passada como parametro?
		 */
		EntityManager em = new ConnectionFactory().getEntityManeger();
		em.getTransaction().begin();
		new AlunoRepository(em).editar(alunoEntity);
		em.getTransaction().commit();
	}
}

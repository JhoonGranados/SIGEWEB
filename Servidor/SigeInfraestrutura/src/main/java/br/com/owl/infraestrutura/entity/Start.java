package br.com.owl.infraestrutura.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.owl.infraestrutura.repository.AlunoRepository;

public class Start {
	public static void main(String[] args) {
		try {		
			/* Create EntityManagerFactory */
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("sige-persist");
	 
			/* Create EntityManager */
			EntityManager em = emf.createEntityManager();
			
			AlunoRepository alunoRep = new AlunoRepository(em);
			AlunoEntity aluno = alunoRep.buscarPorMatricula(20162);
			em.getTransaction().begin();
			aluno.setNome("Jose");
			em.getTransaction().commit();
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

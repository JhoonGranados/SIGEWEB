package br.com.owl.application.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.owl.application.dto.ProfessorForm;
import br.com.owl.application.dto.TarefaForm;
import br.com.owl.dominio.Professor;
import br.com.owl.infraestrutura.entity.ProfessorEntity;
import br.com.owl.infraestrutura.entity.TarefasEntity;

public class ProfessorConverter {

	public ProfessorEntity toEntity(ProfessorForm professorForm) {
		ProfessorEntity professorEntity = new ProfessorEntity();

		professorEntity.setMatricula(professorForm.getMatricula());
		professorEntity.setNome(professorForm.getNome());
		professorEntity.setSobrenome(professorForm.getSobrenome());
		professorEntity.setCpf(professorForm.getCpf());
		professorEntity.setDataNascimento(professorForm.getDataNascimento());
		professorEntity.setTelefone(professorForm.getTelefone());
		professorEntity.setEmail(professorForm.getEmail());
		professorEntity.setMateria(professorForm.getMateria());
		return professorEntity;
	}

	public ProfessorForm toForm(ProfessorEntity professorEntity) {
		ProfessorForm professorForm = new ProfessorForm();

		professorForm.setMatricula(professorEntity.getMatricula());
		professorForm.setNome(professorEntity.getNome());
		professorForm.setSobrenome(professorEntity.getSobrenome());
		professorForm.setCpf(professorEntity.getCpf());
		professorForm.setDataNascimento(professorEntity.getDataNascimento());
		professorForm.setTelefone(professorEntity.getTelefone());
		professorForm.setEmail(professorEntity.getEmail());
		professorForm.setMateria(professorEntity.getMateria());
		return professorForm;
	}

	public List<ProfessorForm> toForm(List<ProfessorEntity> listProfessoresEntity) {
		List<ProfessorForm> listaProfessorForm = new ArrayList<ProfessorForm>();
		for (int i = 0; i < listProfessoresEntity.size(); i++) {
			listaProfessorForm.add(toForm(listProfessoresEntity.get(i)));
		}
		
		return listaProfessorForm;
	}

	public TarefasEntity toTarefaEntity(TarefaForm tarefaForm) {
		return null;
	}

	public List<TarefaForm> toTarefasForm(List<TarefasEntity> listaTarefasEntity) {
		return null;
	}

}

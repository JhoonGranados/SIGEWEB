package br.com.owl.application.conversor;

import java.util.ArrayList;
import java.util.List;

import br.com.owl.application.dto.AlunoForm;
import br.com.owl.application.dto.TarefaForm;
import br.com.owl.infraestrutura.entity.AlunoEntity;
import br.com.owl.infraestrutura.entity.TarefasEntity;

public class AlunoConverter {

	public AlunoEntity toEntity(AlunoForm alunoForm) {
		AlunoEntity alunoEntity = new AlunoEntity();

		alunoEntity.setMatricula(alunoForm.getMatricula());
		alunoEntity.setNome(alunoForm.getNome());
		alunoEntity.setSobrenome(alunoForm.getSobrenome());
		alunoEntity.setNomeMae(alunoForm.getNomeMae());
		alunoEntity.setNomePai(alunoForm.getNomePai());
		alunoEntity.setTelefone(alunoForm.getTelefone());
		alunoEntity.setEmail(alunoForm.getEmail());
		alunoEntity.setTurma(alunoForm.getTurma());
		alunoEntity.setDataNascimento(alunoForm.getDataNascimento());

		return alunoEntity;
	}
	
	public AlunoForm toForm(AlunoEntity alunoEntity){
		AlunoForm alunoForm = new AlunoForm();
		
		alunoForm.setMatricula(alunoEntity.getMatricula());
		alunoForm.setNome(alunoEntity.getNome());
		alunoForm.setSobrenome(alunoEntity.getSobrenome());
		alunoForm.setNomeMae(alunoEntity.getNomeMae());
		alunoForm.setNomePai(alunoEntity.getNomePai());
		alunoForm.setTelefone(alunoEntity.getTelefone());
		alunoForm.setEmail(alunoEntity.getEmail());
		alunoForm.setTurma(alunoEntity.getTurma());
		alunoForm.setDataNascimento(alunoEntity.getDataNascimento());
		
		return alunoForm;
	}

	public List<AlunoForm> toForm(List<AlunoEntity> listaAlunoEntity) {
		List<AlunoForm> listaAlunosForm = new ArrayList<AlunoForm>();
		for (int i = 0; i < listaAlunoEntity.size(); i++) {
			AlunoForm aluno = toForm(listaAlunoEntity.get(i));
			listaAlunosForm.add(aluno);
		}
		return listaAlunosForm;
	}

	public List<TarefaForm> tarefasToForm(List<TarefasEntity> listaTarefasEntity) {
		List<TarefaForm> listaTarefasForm = new ArrayList<TarefaForm>();
		for (int i = 0; i < listaTarefasEntity.size() - 1; i++) {
			TarefaForm tarefaForm = tarefasToForm(listaTarefasEntity.get(i));
			listaTarefasForm.add(tarefaForm);
		}
		return listaTarefasForm;
	}
	
	public TarefaForm tarefasToForm(TarefasEntity tarefasEntity){
		TarefaForm tarefasForm = new TarefaForm();
		
		tarefasForm.setDescricao(tarefasEntity.getDescricao());
		tarefasForm.setMateria(tarefasEntity.getMateria());
		tarefasForm.setSerie(tarefasEntity.getMateria());
		
		return tarefasForm;
	}
}

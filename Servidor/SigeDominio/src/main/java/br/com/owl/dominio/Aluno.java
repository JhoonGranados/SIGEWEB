package br.com.owl.dominio;

import java.util.List;
import java.util.Random;

public class Aluno {
	
	private int matricula;
	private String nome;
	private String sobrenome;
	private Turma turma;
	private List<Tarefa> tarefas;

	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public int gerarMatricula(){
		int valorAleatorio = new Random().nextInt(4);
		String matricula = "2016" + String.valueOf(valorAleatorio); 
		return Integer.parseInt(matricula);
	}
}

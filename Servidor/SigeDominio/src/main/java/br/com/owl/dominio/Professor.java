package br.com.owl.dominio;

import java.util.Random;

import br.com.owl.dominio.enuns.Materia;

public class Professor {
	
	private int matricula;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String dataNascimento;
	private String telefone;
	private String email;
	private Materia materias;
	
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Materia getMaterias() {
		return materias;
	}
	public void setMaterias(Materia materias) {
		this.materias = materias;
	}
	public int gerarMatricula() {
		int valorAleatorio = new Random().nextInt(4);
		String matricula = "2015" + String.valueOf(valorAleatorio); 
		return Integer.parseInt(matricula);
	}
}

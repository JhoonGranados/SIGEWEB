package br.com.owl.dominio;

import br.com.owl.dominio.enuns.PermissaoAcesso;

public class Usuarios {

	private int matricula; 
	private String nome;
	private int login;
	private String senha;
	private PermissaoAcesso permissoes;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getLogin() {
		return login;
	}
	public void setLogin(int login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public PermissaoAcesso getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(PermissaoAcesso permissoes) {
		this.permissoes = permissoes;
	}
}

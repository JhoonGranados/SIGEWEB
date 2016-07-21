package br.com.owl.dominio.interfaces;

import java.util.List;

import br.com.owl.entity.Entidade;

public interface IRepositorio {
	void salvar(Entidade entidade);
	List<Entidade> buscar();
	Entidade buscar(int id);
}

package br.com.owl.application.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.owl.application.application.AlunoApplication;
import br.com.owl.application.dto.AlunoForm;
import br.com.owl.application.dto.TarefaForm;

@Path("/aluno")
public class AlunoService {
	
	private AlunoApplication alunoApplication; 
	
	public AlunoService() {
		alunoApplication = new AlunoApplication();
	}

	@Path("/salvar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(String json){
		System.out.println(json);
		AlunoForm alunoForm = new Gson().fromJson(json, AlunoForm.class);
		alunoApplication.salvar(alunoForm);
		URI uri = URI.create("/aluno/salvar");
		return Response.created(uri).build();
	}
	
	@Path("/editar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(String json){
		AlunoForm alunoForm = new Gson().fromJson(json, AlunoForm.class);
		alunoApplication.editar(alunoForm);
		URI uri = URI.create("/aluno/editar");
		return Response.created(uri).build();
	}
	
	@Path("/buscar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(){
		List<AlunoForm> listaAlunosForm = this.alunoApplication.buscarAlunos();
		String json = new Gson().toJson(listaAlunosForm);
		return Response.ok(json).build();
	}
	
	@Path("/buscar/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id") int id){
		AlunoForm alunoForm = this.alunoApplication.buscarAlunos(id); 
		String json = new Gson().toJson(alunoForm);
		return Response.ok(json).build();
	}
	
	@Path("/buscarFiltro/{filtro}")
	@GET
	public Response buscarFilro(@PathParam("filtro") String filtro){
		List<AlunoForm> listaAlunosForm = this.alunoApplication.buscarAlunos(filtro);
		String json = new Gson().toJson(listaAlunosForm);
		return Response.ok(json).build();
	}
	
	@Path("/remove/{id}")
	@DELETE
	public Response remover(@PathParam("id") int id){
		this.alunoApplication.remover(id);
		URI uri = URI.create("/aluno/remover");
		return Response.created(uri).build();
	}
	
	@Path("/buscarTarefas/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarTarefas(@PathParam("id") int id){
		List<TarefaForm> listaTarefas = this.alunoApplication.buscarTarefas(id);
		String json = new Gson().toJson(listaTarefas);
		return Response.ok(json).build();
	}
}

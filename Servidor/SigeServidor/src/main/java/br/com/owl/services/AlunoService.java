package br.com.owl.services;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.owl.application.AlunoApplication;
import br.com.owl.application.AlunoForm;

@Path("/aluno")
public class AlunoService {
	
	AlunoApplication alunoApplication;
	
	public AlunoService() {
		alunoApplication = new AlunoApplication();
	}
	
	@Path("/salvar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(AlunoForm alunoForm){
		alunoApplication.salvar(conteudo);
		URI uri = URI.create("/aluno/salvar");
		return Response.created(uri).build();
	}
	
	@Path("/buscar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(){
		return Response.ok(this.alunoApplication.buscarAlunos()).build();
	}
	
	@Path("/buscar/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id") int id){
		return Response.ok(this.alunoApplication.buscarAlunos(id)).build();
	}
}

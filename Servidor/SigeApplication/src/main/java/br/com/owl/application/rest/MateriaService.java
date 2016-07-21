package br.com.owl.application.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.owl.application.application.MateriaApplication;

@Path("/materia")
public class MateriaService {
	
	
	private MateriaApplication materiaApplication;
	
	public MateriaService() {
		this.materiaApplication = new MateriaApplication();
	}
	
	@GET
	@Path("/buscarMaterias")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarMaterias(){
		String json = new Gson().toJson(this.materiaApplication.buscarMaterias());
		return Response.ok(json).build();
	}

}

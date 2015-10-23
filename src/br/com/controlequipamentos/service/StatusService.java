package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.StatusDAO;
import br.com.controlequipamentos.pojo.Status;

@Path("/v1/status")
public class StatusService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Status> listarStatuss(){
		StatusDAO statusDao;
		try {
			statusDao = new StatusDAO();
			return statusDao.select();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Status> listarStatus(@PathParam("id") int id){
		StatusDAO statusDao;
		try {
			statusDao = new StatusDAO();
			return statusDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@PUT
	public void alterar(Status status){
		StatusDAO statusDao;
		try {
			statusDao = new StatusDAO();
			statusDao.update(status);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Status status){
		StatusDAO statusDao;
		try {
			statusDao = new StatusDAO();
			statusDao.insert(status);
		} catch (Exception e) {
			System.out.println( e );
		}	
	}
}

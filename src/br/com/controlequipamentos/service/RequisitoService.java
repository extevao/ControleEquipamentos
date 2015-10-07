package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.RequisitoDAO;
import br.com.controlequipamentos.pojo.Requisito;

@Path("/v1/requisito")
public class RequisitoService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Requisito> listarRequisitos(){
		
		RequisitoDAO requisitoDAO;
		try {
			requisitoDAO = new RequisitoDAO();
			return requisitoDAO.select();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Requisito> listarRequisito(@PathParam("id") int id){
		RequisitoDAO requisitoDAO;
		try {
			requisitoDAO = new RequisitoDAO();
			return requisitoDAO.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@PUT
	public void alterar(Requisito requisito){
		RequisitoDAO requisitoDao;
		try {
			requisitoDao = new RequisitoDAO();
			requisitoDao.update(requisito);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Requisito requisito){
		RequisitoDAO requisitoDao;
		try {
			requisitoDao = new RequisitoDAO();
			requisitoDao.insert(requisito);
			
		} catch (Exception e) {
			System.out.println( e );
		}	
	}
}

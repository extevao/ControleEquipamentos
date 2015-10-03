package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.RequisitoDao;
import br.com.controlequipamentos.pojo.Requisito;
@Path("/v1/requisito")
public class RequisitoService {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Requisito> listarRequisitos(){
		
		RequisitoDao manutencaoDao;
		try {
			manutencaoDao = new RequisitoDao();
			return manutencaoDao.select();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Requisito> listarRequisito(@PathParam("id") int id){
		RequisitoDao requisitoDao;
		try {
			requisitoDao = new RequisitoDao();
			return requisitoDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@PUT
	public void alterar(Requisito requisito){
		RequisitoDao requisitoDao;
		try {
			requisitoDao = new RequisitoDao();
			requisitoDao.update(requisito);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Requisito requisito){
		RequisitoDao requisitoDao;
		try {
			requisitoDao = new RequisitoDao();
			requisitoDao.insert(requisito);
			
		} catch (Exception e) {
			System.out.println( e );
		}	
	}
}

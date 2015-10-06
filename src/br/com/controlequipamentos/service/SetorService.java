package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.SetorDAO;
import br.com.controlequipamentos.pojo.Setor;

@Path("/v1/setor")
public class SetorService {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Setor> listarSetores(){
		
		SetorDAO setorDao;
		try {
			setorDao = new SetorDAO();
			return setorDao.select();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Setor> listarSetor(@PathParam("id") int id){
		SetorDAO setorDao;
		try {
			setorDao = new SetorDAO();
			return setorDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@PUT
	public void alterar(Setor setor){
		SetorDAO setorDao;
		try {
			setorDao = new SetorDAO();
			setorDao.update(setor);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Setor setor){
		SetorDAO setorDao;
		try {
			setorDao = new SetorDAO();
			setorDao.insert(setor);
			
		} catch (Exception e) {
			System.out.println( e );
		}	
	}
	
}

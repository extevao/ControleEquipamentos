package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.SetorDao;
import br.com.controlequipamentos.pojo.Setor;

@Path("/v1/setor")
public class SetorService {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Setor> listaUsuarios(){
		
		SetorDao setorDao;
		try {
			setorDao = new SetorDao();
			return setorDao.select();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Setor> listaCategoria(@PathParam("id") int id){
		SetorDao setorDao;
		try {
			setorDao = new SetorDao();
			return setorDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@PUT
	public void alterar(Setor setor){
		SetorDao setorDao;
		try {
			setorDao = new SetorDao();
			setorDao.update(setor);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void salvar (Setor setor){
		SetorDao setorDao;
		try {
			setorDao = new SetorDao();
			setorDao.insert(setor);
			
		} catch (Exception e) {
			System.out.println( e );
		}	
	}
	
}

package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.ManutencaoDAO;
import br.com.controlequipamentos.pojo.Manutencao;

@Path("/v1/manutencao")
public class ManutencaoService {
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Manutencao> listarManutencoes(){
		
		ManutencaoDAO manutencaoDao;
		try {
			manutencaoDao = new ManutencaoDAO();
			return manutencaoDao.select();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Manutencao> listarManutencao(@PathParam("id") int id){
		ManutencaoDAO manutencaoDao;
		try {
			manutencaoDao = new ManutencaoDAO();
			return manutencaoDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@PUT
	public void alterar(Manutencao equipamento){
		ManutencaoDAO manutencaoDao;
		try {
			manutencaoDao = new ManutencaoDAO();
			manutencaoDao.update(equipamento);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Manutencao manutencao){
		ManutencaoDAO manutencaoDao;
		try {
			manutencaoDao = new ManutencaoDAO();
			manutencaoDao.insert(manutencao);
			
		} catch (Exception e) {
			System.out.println( e );
		}	
	}

}

package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.EquipamentoDao;
import br.com.controlequipamentos.pojo.Equipamento;

public class EquipamentoService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Equipamento> listarEquipamentos(){
		
		EquipamentoDao categoriaDao;
		try {
			categoriaDao = new EquipamentoDao();
			return categoriaDao.select();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Equipamento> listarEquipamento(@PathParam("id") int id){
		EquipamentoDao categoriaDao;
		try {
			categoriaDao = new EquipamentoDao();
			return categoriaDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@PUT
	public void alterar(Equipamento equipamento){
		EquipamentoDao categoriaDao;
		try {
			categoriaDao = new EquipamentoDao();
			categoriaDao.update(equipamento);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Equipamento equipamento){
		EquipamentoDao categoriaDao;
		try {
			categoriaDao = new EquipamentoDao();
			categoriaDao.insert(equipamento);
			
		} catch (Exception e) {
			System.out.println( e );
		}	
	}
	
}

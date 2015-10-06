package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.EquipamentoDAO;
import br.com.controlequipamentos.pojo.Equipamento;

@Path("/v1/equipamento")
public class EquipamentoService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Equipamento> listarEquipamentos(){
		
		EquipamentoDAO equipamentoDAO;
		try {
			equipamentoDAO = new EquipamentoDAO();
			return equipamentoDAO.select();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Equipamento> listarEquipamento(@PathParam("id") int id){
		EquipamentoDAO equipamentoDAO;
		try {
			equipamentoDAO = new EquipamentoDAO();
			return equipamentoDAO.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@PUT
	public void alterar(Equipamento equipamento){
		EquipamentoDAO categoriaDao;
		try {
			categoriaDao = new EquipamentoDAO();
			categoriaDao.update(equipamento);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Equipamento equipamento){
		EquipamentoDAO categoriaDao;
		try {
			categoriaDao = new EquipamentoDAO();
			categoriaDao.insert(equipamento);
			
		} catch (Exception e) {
			System.out.println( e );
		}	
	}
	
}

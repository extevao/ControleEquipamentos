package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import br.com.controlequipamentos.dao.ManutencaoEquipamentoDAO;
import br.com.controlequipamentos.pojo.ManutencaoEquipamento;


@Path("/v1/manutencoes/equipamento")
public class ManutencoesEquipamentoService {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<ManutencaoEquipamento> listarManutencoesEquipamento(@PathParam("id") int id){
		ManutencaoEquipamentoDAO equipamentoDAO;
		try {
			equipamentoDAO = new ManutencaoEquipamentoDAO();
			return equipamentoDAO.selectManutencaoEquipamento(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
}

package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.EquipamentoRelatorioDAO;
import br.com.controlequipamentos.pojo.RelatorioEquipamento;

@Path("/v1/relatorio/equipamentos/setor")
public class RelatorioEquipamentoMarcaService {


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<RelatorioEquipamento> listarEquipamento(){
		EquipamentoRelatorioDAO equipamentoDAO;
		try {
			equipamentoDAO = new EquipamentoRelatorioDAO();
			return equipamentoDAO.selectEquipamentoSetor();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
}

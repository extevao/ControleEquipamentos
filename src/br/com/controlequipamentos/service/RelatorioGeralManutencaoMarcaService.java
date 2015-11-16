package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.ManutencaoEquipamentoDAO;
import br.com.controlequipamentos.pojo.RelatorioGeralManutencaoMarca;

@Path("/v1/manutencoes/qtd/equipamento/marca")
public class RelatorioGeralManutencaoMarcaService {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public ArrayList<RelatorioGeralManutencaoMarca> listarQtdManutencoesMarca(){
		ManutencaoEquipamentoDAO equipamentoDAO;
		try {
			equipamentoDAO = new ManutencaoEquipamentoDAO();
			return equipamentoDAO.listaRelatorioGeralManutencaoMarca();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	

}

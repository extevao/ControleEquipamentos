package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.SetorRequisitoDAO;
import br.com.controlequipamentos.pojo.SetorRequisito;

@Path("/v1/setor/requisito")
public class SetorRequisitoService {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public ArrayList<SetorRequisito> listaSetorMarca(){
		SetorRequisitoDAO sr;
		try {
			sr = new SetorRequisitoDAO();
			return sr.selectListaRequisitoSetor();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

}

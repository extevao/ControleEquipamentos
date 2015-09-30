package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.CategoriaDao;
import br.com.controlequipamentos.pojo.Categoria;


@Path("/v1/categoria")
public class CategoriaService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Categoria> listaUsuarios(){
		
		CategoriaDao categoriaDao;
		try {
			categoriaDao = new CategoriaDao();
			return categoriaDao.select();
		} catch (Exception e) {
			return null;
		}	
	}
}

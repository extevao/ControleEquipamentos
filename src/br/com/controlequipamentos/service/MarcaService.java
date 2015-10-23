package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.controlequipamentos.dao.MarcaDAO;
import br.com.controlequipamentos.pojo.Marca;

@Path("/v1/marca")
public class MarcaService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Marca> listarMarcas(){
		
		MarcaDAO marcaDao;
		try {
			marcaDao = new MarcaDAO();
			return marcaDao.select();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Marca> listarMarca(@PathParam("id") int id){
		MarcaDAO marcaDao;
		try {
			marcaDao = new MarcaDAO();
			return marcaDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@PUT
	public void alterar(Marca marca){
		MarcaDAO marcaDao;
		try {
			marcaDao = new MarcaDAO();
			marcaDao.update(marca);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Marca marca){
		MarcaDAO marcaDao;
		try {
			marcaDao = new MarcaDAO();
			marcaDao.insert(marca);
			
		} catch (Exception e) {
			System.out.println( e );
		}	
	}
	
}

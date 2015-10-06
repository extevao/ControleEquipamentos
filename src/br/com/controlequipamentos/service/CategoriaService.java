package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.CategoriaDAO;
import br.com.controlequipamentos.pojo.Categoria;



@Path("/v1/categoria")
public class CategoriaService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Categoria> listarCategorias(){
		
		CategoriaDAO categoriaDao;
		try {
			categoriaDao = new CategoriaDAO();
			return categoriaDao.select();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Categoria> listarCategoria(@PathParam("id") int id){
		CategoriaDAO categoriaDao;
		try {
			categoriaDao = new CategoriaDAO();
			return categoriaDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	@PUT
	public void alterar(Categoria categoria){
		CategoriaDAO categoriaDao;
		try {
			categoriaDao = new CategoriaDAO();
			categoriaDao.update(categoria);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Categoria categoria){
		CategoriaDAO categoriaDao;
		try {
			categoriaDao = new CategoriaDAO();
			categoriaDao.insert(categoria);
			
		} catch (Exception e) {
			System.out.println( e );
		}	
	}
}

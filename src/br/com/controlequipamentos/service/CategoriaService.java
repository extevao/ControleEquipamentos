package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Categoria> listaCategoria(@PathParam("id") int id){
		CategoriaDao categoriaDao;
		try {
			categoriaDao = new CategoriaDao();
			return categoriaDao.selectId(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@PUT
	public void alterar(Categoria categoria){
		CategoriaDao categoriaDao;
		try {
			categoriaDao = new CategoriaDao();
			categoriaDao.update(categoria);

		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao tentar alterar a categoria " + e);
		}
	}
	@POST
	public void salvar (Categoria categoria){
		CategoriaDao categoriaDao;
		try {
			categoriaDao = new CategoriaDao();
			categoriaDao.insert(categoria);
			
			
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao salvar a nova categoria " + e );
		}	
	}
}

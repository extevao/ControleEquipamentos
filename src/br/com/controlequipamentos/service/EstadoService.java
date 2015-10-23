package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.EstadoDAO;
import br.com.controlequipamentos.pojo.Estado;



@Path("/v1/estado")
public class EstadoService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Estado> listarEstados(){
		EstadoDAO estadoDao;
		try {
			estadoDao = new EstadoDAO();
			return estadoDao.select();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}	
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Estado> listarEstado(@PathParam("id") int id){
		EstadoDAO estadoDao;
		try {
			estadoDao = new EstadoDAO();
			return estadoDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@PUT
	public void alterar(Estado estado){
		EstadoDAO estadoDao;
		try {
			estadoDao = new EstadoDAO();
			estadoDao.update(estado);

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Estado estado){
		EstadoDAO estadoDao;
		try {
			estadoDao = new EstadoDAO();
			estadoDao.insert(estado);
			
		} catch (Exception e) {
			System.out.println( e );
		}	
	}
}

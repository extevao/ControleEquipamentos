package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.UsuarioDAO;
import br.com.controlequipamentos.pojo.Usuario;

@Path("/v1/usuario")
public class UsuarioService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Usuario> listarUsuarios(){
		
		UsuarioDAO usuarioDAO;
		try {
			usuarioDAO = new UsuarioDAO();
			return usuarioDAO.select();
		} catch (Exception e) {
			return null;
		}	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Usuario> usuario(@PathParam("id") int id){
		UsuarioDAO usuarioDAO;
		try {
			usuarioDAO = new UsuarioDAO();
			return usuarioDAO.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@PUT
	public void alterar(Usuario usuario){
		UsuarioDAO usuarioDAO;
		try {
			usuarioDAO = new UsuarioDAO();
			usuarioDAO.update(usuario);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Usuario usuario){
		UsuarioDAO usuarioDAO;
		try {
			usuarioDAO = new UsuarioDAO();
			usuarioDAO.insert(usuario);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	

}

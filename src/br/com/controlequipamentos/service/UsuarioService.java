package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.UsuarioDao;
import br.com.controlequipamentos.pojo.Usuario;


@Path("/v1/usuario")
public class UsuarioService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Usuario> listaUsuarios(){
		
		UsuarioDao usuarioDao;
		try {
			usuarioDao = new UsuarioDao();
			return usuarioDao.select();
		} catch (Exception e) {
			return null;
		}	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Usuario> listaUsuarioId(@PathParam("id") int id){
		UsuarioDao usuarioDao;
		try {
			usuarioDao = new UsuarioDao();
			return usuarioDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@PUT
	public void alterar(Usuario usuario){
		UsuarioDao usuarioDao;
		try {
			usuarioDao = new UsuarioDao();
			usuarioDao.update(usuario);
			System.out.println("Usuário alterado com sucesso apartir do serviço");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void salvar (Usuario usuario){
		UsuarioDao usuarioDao;
		try {
			usuarioDao = new UsuarioDao();
			usuarioDao.insert(usuario);
			
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	

}

package br.com.controlequipamentos.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.controlequipamentos.dao.FuncionarioDao;
import br.com.controlequipamentos.dao.UsuarioTesteDao;
import br.com.controlequipamentos.pojo.Funcionario;
import br.com.controlequipamentos.pojo.UsuarioTeste;


@Path("/v1/usuario")
public class UsuarioService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<UsuarioTeste> listarFuncionarios(){
		
		UsuarioTesteDao funcionarioDao;
		try {
			funcionarioDao = new UsuarioTesteDao();
			return funcionarioDao.select();
		} catch (Exception e) {
			return null;
		}	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<UsuarioTeste> listarFuncionario(@PathParam("id") int id){
		UsuarioTesteDao funcionarioDao;
		try {
			funcionarioDao = new UsuarioTesteDao();
			return funcionarioDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@PUT
	public void alterar(UsuarioTeste funcionario){
		UsuarioTesteDao funcionarioDao;
		try {
			funcionarioDao = new UsuarioTesteDao();
			funcionarioDao.update(funcionario);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (UsuarioTeste funcionario){
		UsuarioTesteDao funcionarioDao;
		try {
			funcionarioDao = new UsuarioTesteDao();
			funcionarioDao.insert(funcionario);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	

}

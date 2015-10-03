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
import br.com.controlequipamentos.pojo.Funcionario;


@Path("/v1/funcionario")
public class FuncionarioService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Funcionario> listarFuncionarios(){
		
		FuncionarioDao funcionarioDao;
		try {
			funcionarioDao = new FuncionarioDao();
			return funcionarioDao.select();
		} catch (Exception e) {
			return null;
		}	
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ArrayList<Funcionario> listarFuncionario(@PathParam("id") int id){
		FuncionarioDao funcionarioDao;
		try {
			funcionarioDao = new FuncionarioDao();
			return funcionarioDao.selectId(id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@PUT
	public void alterar(Funcionario funcionario){
		FuncionarioDao funcionarioDao;
		try {
			funcionarioDao = new FuncionarioDao();
			funcionarioDao.update(funcionario);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@POST
	public void inserir (Funcionario funcionairo){
		FuncionarioDao funcionarioDao;
		try {
			funcionarioDao = new FuncionarioDao();
			funcionarioDao.insert(funcionairo);
			
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	
}

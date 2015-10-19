package pacoteTeste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import br.com.controlequipamentos.dao.EquipamentoDAO;
import br.com.controlequipamentos.dao.UsuarioTesteDao;
import br.com.controlequipamentos.pojo.Equipamento;
import br.com.controlequipamentos.pojo.UsuarioTeste;

public class TesteConexaoBanco {

	public static void main(String[] args) {


		try {
		
			listar();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	public  static void listar() throws NamingException{
		EquipamentoDAO dao = new EquipamentoDAO();
		for(Equipamento obj : dao.select()){
			System.out.println(obj.toString());
		}
	}
	
	public static void inserir() throws NamingException{
		Equipamento novo = new Equipamento();
		novo.setNome("OptiPlex 3020 Micro");
		//novo.setDataCompra(2015-07-24);
		//novo.setDataCadastro(2015-08-15);
		//novo.setDataInicioOperacao(2015-09-10);
		novo.setMarca("Dell");
		novo.setIdCategoria(3);
		novo.setIdSetor(2);
		novo.setIdFuncionario(4);
		novo.setIdRequisito(4);
		
		EquipamentoDAO dao = new EquipamentoDAO();
		//dao.insert(novo);
	}
	public static void update() throws NamingException{
		UsuarioTeste novoFuncionario = new UsuarioTeste(14,"Major","Sei La","capitao@aod.com");
		UsuarioTesteDao funcionario = new UsuarioTesteDao();
		funcionario.update(novoFuncionario);
	}
	
	
	public static void  conexaoteste (){
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM usuario");
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/base", "root", "");
			PreparedStatement stmt =  con.prepareStatement(sbSelect.toString());
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("nome"));
				System.out.println(rs.getString("sobrenome"));
				System.out.println(rs.getString("email"));
				System.out.println("=========================");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}

package pacoteTeste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import br.com.controlequipamentos.dao.UsuarioTesteDao;

import br.com.controlequipamentos.pojo.UsuarioTeste;

public class TesteConexaoBanco {

	public static void main(String[] args) {


		try {
			update();
			listar();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	public  static void listar() throws NamingException{
		UsuarioTesteDao funcionarioDao = new UsuarioTesteDao();
		for(UsuarioTeste funcionario : funcionarioDao.select()){
			System.out.println(funcionario.getId());
			System.out.println(funcionario.getNome());
			System.out.println(funcionario.getEmail());
		}
		System.out.println("teste");
	}
	
	public static void inserir() throws NamingException{
		UsuarioTeste novoFuncionario = new UsuarioTeste("Teste","teste","teste@hotmail.com");
		UsuarioTesteDao funcionario = new UsuarioTesteDao();
		funcionario.insert(novoFuncionario);
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

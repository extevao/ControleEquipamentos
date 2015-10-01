package pacoteTeste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import br.com.controlequipamentos.dao.FuncionarioDao;
import br.com.controlequipamentos.pojo.Funcionario;

public class ConexaoBanco {

	public static void main(String[] args) {
	
		/*no inicio eu estava usando a classe 
		 * de usu�rio para testar, mas depois alteramos as suas informa��es, 
		 * e agora eu passei a usuar o funcionario como modelo, pois ela � muito
		 * similar ao antiga classe usu�rio por esse motivo est� bem loko esta 
		 * classe 
		 */
		
		listarUsuariosCadastrados();
	}
	public  static void listarUsuariosCadastrados(){
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		for(Funcionario funcionario : funcionarioDao.select()){
			System.out.println(funcionario.getId());
			System.out.println(funcionario.getNome());
			System.out.println(funcionario.getEmail());
		}
		System.out.println("teste");
	}
	
	public static void inserirUsuario(){
		Funcionario novoUsuario = new Funcionario();
		novoUsuario.setNome("Major");
		novoUsuario.setSobrenome("guimar�es");
		novoUsuario.setEmail("guimar�es@aod.com.br");
		FuncionarioDao usuarioDao = new FuncionarioDao ();
		usuarioDao.insert(novoUsuario);
	}
	
	public static void listarPorId(int id){
		FuncionarioDao usuarioDao = new FuncionarioDao ();
		
		for(Funcionario usuariof : usuarioDao.selectId(id)){
			System.out.println(usuariof.getId());
			System.out.println(usuariof.getNome());
			System.out.println(usuariof.getSobrenome());
			System.out.println(usuariof.getEmail());
		}
	}
	public static void  conexao (){
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
	public static void alterar(){
		Funcionario usuario = new Funcionario();
		FuncionarioDao usuarioDao = new FuncionarioDao();
		
		usuario.setId(3);
		usuario.setNome("Fabio");
		usuario.setSobrenome("Machado da Rosa");
		usuario.setEmail("suit@novoemail.com");
		usuarioDao.update(usuario);
	}
	
}

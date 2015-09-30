package pacoteTeste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import br.com.controlequipamentos.dao.UsuarioDao;
import br.com.controlequipamentos.pojo.Usuario;

public class ConexaoBanco {

	public static void main(String[] args) {
		
		
		listarUsuariosCadastrados();
	}
	public  static void listarUsuariosCadastrados(){
		UsuarioDao usuarioDao = new UsuarioDao();
		for(Usuario usuariof : usuarioDao.select()){
			System.out.println(usuariof.getId());
			System.out.println(usuariof.getNome());
			System.out.println(usuariof.getEmail());
		}
		System.out.println("teste");
	}
	
	public static void inserirUsuario(){
		Usuario novoUsuario = new Usuario();
		novoUsuario.setNome("Major");
		novoUsuario.setSobrenome("guimarães");
		novoUsuario.setEmail("guimarães@aod.com.br");
		UsuarioDao usuarioDao = new UsuarioDao ();
		usuarioDao.insert(novoUsuario);
	}
	
	public static void listarPorId(int id){
		UsuarioDao usuarioDao = new UsuarioDao ();
		
		for(Usuario usuariof : usuarioDao.selectId(id)){
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
		Usuario usuario = new Usuario();
		UsuarioDao usuarioDao = new UsuarioDao();
		
		usuario.setId(3);
		usuario.setNome("Fabio");
		usuario.setSobrenome("Machado da Rosa");
		usuario.setEmail("suit@novoemail.com");
		usuarioDao.update(usuario);
	}
	
}

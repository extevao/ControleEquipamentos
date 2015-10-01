package br.com.controlequipamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.controlequipamentos.pojo.Usuario;


public class UsuarioDao {
	
	private Connection connection = ConnectionFactory.getConnection();
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ArrayList<Usuario> select (){
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Usuario");
		try {
			this.stmt = this.connection.prepareStatement(sbSelect.toString());
			this.rs = stmt.executeQuery();
			while (rs.next()) {	
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setIdFuncionario(rs.getInt("idFuncionario"));
				listaUsuarios.add(usuario);
			}
			return listaUsuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Usuario> selectId(int id) {
		ArrayList<Usuario> listaUsuario = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM usuario WHERE id  = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbSelec.toString());
			this.stmt.setInt(1, id);
			this.rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setIdFuncionario(rs.getInt("idFuncionario"));
				listaUsuario.add(usuario);
			}
			return listaUsuario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void insert(Usuario usuario) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO usuario (login, senha, idFuncionario) VALUES (?, ?, ?)");
		try {
			this.stmt = this.connection.prepareStatement(sbInsert.toString());
			this.stmt.setString(1, usuario.getLogin());
			this.stmt.setString(2, usuario.getSenha());
			this.stmt.setInt(3, usuario.getIdFuncionario());
			this.stmt.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("Erro ao salvar um novo usuário " + e);
		}
	}

	public void update(Usuario usuario) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE usuario SET login = ?, senha= ?, idFuncionario= ? WHERE id = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbUpdate.toString());
			this.stmt.setString(1, usuario.getLogin());
			this.stmt.setString(2, usuario.getSenha());
			this.stmt.setInt(3, usuario.getIdFuncionario());
			this.stmt.setInt(4, usuario.getId());
			this.stmt.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do usuário. " + e);
		}
	}

	
}

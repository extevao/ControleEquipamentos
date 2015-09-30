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
		sbSelect.append("SELECT * FROM usuario");
		try {
			this.stmt = this.connection.prepareStatement(sbSelect.toString());
			this.rs = stmt.executeQuery();
			while (rs.next()) {	
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setEmail(rs.getString("email"));
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
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setEmail(rs.getString("email"));
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
		sbInsert.append("INSERT INTO usuario (nome, sobrenome, email) VALUES (?, ?, ?)");
		try {
			this.stmt = this.connection.prepareStatement(sbInsert.toString());
			this.stmt.setString(1, usuario.getNome());
			this.stmt.setString(2, usuario.getSobrenome());
			this.stmt.setString(3, usuario.getEmail());
			this.stmt.executeUpdate();
			System.out.println("Usuário inserido com sucesso!");			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo usuário: " + e);
		}
	}

	public void update(Usuario usuario) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE usuario SET nome = ?, sobrenome = ?, email = ? WHERE id = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbUpdate.toString());
			this.stmt.setString(1, usuario.getNome());
			this.stmt.setString(2, usuario.getSobrenome());
			this.stmt.setString(3, usuario.getEmail());
			this.stmt.setInt(4, usuario.getId());
			this.stmt.executeUpdate();
			System.out.println("Usuário alterado com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do usuário. " + e);
		}
	}

	
}

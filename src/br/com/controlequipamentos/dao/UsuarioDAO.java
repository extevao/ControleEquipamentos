package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import br.com.controlequipamentos.pojo.Usuario;


public class UsuarioDAO extends ConnectionFactory {
	
	
	public ArrayList<Usuario> select (){
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Usuario");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
			while (rs.next()) {	
				Usuario usuario = new Usuario();
				usuario.setId(rs.getString("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setIdStatus(rs.getString("idStatus"));
				usuario.setIdSetor(rs.getString("idSetor"));
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
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getString("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setIdStatus(rs.getString("idStatus"));
				usuario.setIdSetor(rs.getString("idSetor"));
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
		sbInsert.append("INSERT INTO usuario (nome, sobrenome, email, login, senha, idStatus, idSetor) VALUES (?, ?, ?, ?, ?, ?, ? )");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, usuario.getNome());
			this.stmtp.setString(2, usuario.getSobrenome());
			this.stmtp.setString(3, usuario.getEmail());
			this.stmtp.setString(4, usuario.getLogin());
			this.stmtp.setString(5, usuario.getSenha());
			this.stmtp.setString(6, usuario.getIdStatus());
			this.stmtp.setString(7, usuario.getIdSetor());
			this.stmtp.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("Erro ao salvar um novo usuário " + e);
		}
	}

	public void update(Usuario usuario) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE usuario SET nome = ?, sobrenome = ?, email = ?, login = ?, senha= ?, idStatus= ?, idSetor = ? WHERE id = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, usuario.getNome());
			this.stmtp.setString(2, usuario.getSobrenome());
			this.stmtp.setString(3, usuario.getEmail());
			this.stmtp.setString(4, usuario.getLogin());
			this.stmtp.setString(5, usuario.getSenha());
			this.stmtp.setString(6, usuario.getIdStatus());
			this.stmtp.setString(7, usuario.getIdSetor());
			this.stmtp.setString(8, usuario.getId());
			this.stmtp.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do usuário. " + e);
		}
	}

	
}

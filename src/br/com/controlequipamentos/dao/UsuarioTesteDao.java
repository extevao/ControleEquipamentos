package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import br.com.controlequipamentos.pojo.UsuarioTeste;

public class UsuarioTesteDao extends ConnectionFactory {


	public UsuarioTesteDao()  {
		super();
	}
	
	public ArrayList<UsuarioTeste> select (){
		ArrayList<UsuarioTeste> listaFuncionarios = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM usuario");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
			while (rs.next()) {	
				UsuarioTeste funcionario = new UsuarioTeste();
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSobrenome(rs.getString("sobrenome"));
				funcionario.setEmail(rs.getString("email"));
		
				listaFuncionarios.add(funcionario);
			}
			return listaFuncionarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<UsuarioTeste> selectId(int id) {
		ArrayList<UsuarioTeste> listaFuncionario = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM usuario WHERE id  = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				UsuarioTeste funcionario = new UsuarioTeste();
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSobrenome(rs.getString("sobrenome"));
				funcionario.setEmail(rs.getString("email"));
				listaFuncionario.add(funcionario);
			}
			return listaFuncionario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(UsuarioTeste funcionario) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO usuario (nome, sobrenome, email) VALUES (?, ?, ?)");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, funcionario.getNome());
			this.stmtp.setString(2, funcionario.getSobrenome());
			this.stmtp.setString(3, funcionario.getEmail());
			this.stmtp.executeUpdate();		
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo funcionário: " + e);
		}
	}

	public void update(UsuarioTeste funcionario) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE usuario SET nome = ?, sobrenome = ?, email = ? WHERE id = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, funcionario.getNome());
			this.stmtp.setString(2, funcionario.getSobrenome());
			this.stmtp.setString(3, funcionario.getEmail());
			this.stmtp.setInt(4, funcionario.getId());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do funcionário. " + e);
		}
	}
}

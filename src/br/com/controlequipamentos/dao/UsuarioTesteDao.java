package br.com.controlequipamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Funcionario;
import br.com.controlequipamentos.pojo.UsuarioTeste;

public class UsuarioTesteDao {

	private Connection connection = ConnectionFactory.getConnection();
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ArrayList<UsuarioTeste> select (){
		ArrayList<UsuarioTeste> listaFuncionarios = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM usuario");
		try {
			this.stmt = this.connection.prepareStatement(sbSelect.toString());
			this.rs = stmt.executeQuery();
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
			this.stmt = this.connection.prepareStatement(sbSelec.toString());
			this.stmt.setInt(1, id);
			this.rs = stmt.executeQuery();
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
		sbInsert.append("INSERT INTO usuario (nome, sobrenome, email, cargo, idSetor) VALUES (?, ?, ?, ?, ?)");
		try {
			this.stmt = this.connection.prepareStatement(sbInsert.toString());
			this.stmt.setString(1, funcionario.getNome());
			this.stmt.setString(2, funcionario.getSobrenome());
			this.stmt.setString(3, funcionario.getEmail());
			this.stmt.executeUpdate();		
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo funcionário: " + e);
		}
	}

	public void update(UsuarioTeste funcionario) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE usuario SET nome = ?, sobrenome = ?, email = ?, cargo=?, idSetor=?  WHERE id = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbUpdate.toString());
			this.stmt.setString(1, funcionario.getNome());
			this.stmt.setString(2, funcionario.getSobrenome());
			this.stmt.setString(3, funcionario.getEmail());
			this.stmt.setInt(6, funcionario.getId());
			this.stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do funcionário. " + e);
		}
	}
}

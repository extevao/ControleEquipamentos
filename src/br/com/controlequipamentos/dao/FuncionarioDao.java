package br.com.controlequipamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Funcionario;



public class FuncionarioDao {

	
	private Connection connection = ConnectionFactory.getConnection();
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ArrayList<Funcionario> select (){
		ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM funcionario");
		try {
			this.stmt = this.connection.prepareStatement(sbSelect.toString());
			this.rs = stmt.executeQuery();
			while (rs.next()) {	
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSobrenome(rs.getString("sobrenome"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setCargo(rs.getString("cargo"));
				funcionario.setIdSetor(rs.getInt("idSetor"));
				
				listaFuncionarios.add(funcionario);
			}
			return listaFuncionarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Funcionario> selectId(int id) {
		ArrayList<Funcionario> listaFuncionario = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM funcionario WHERE id  = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbSelec.toString());
			this.stmt.setInt(1, id);
			this.rs = stmt.executeQuery();
			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setId(rs.getInt("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setSobrenome(rs.getString("sobrenome"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setCargo(rs.getString("cargo"));
				funcionario.setIdSetor(rs.getInt("idSetor"));
				listaFuncionario.add(funcionario);
			}
			return listaFuncionario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(Funcionario funcionario) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO funcionario (nome, sobrenome, email, cargo, idSetor) VALUES (?, ?, ?, ?, ?)");
		try {
			this.stmt = this.connection.prepareStatement(sbInsert.toString());
			this.stmt.setString(1, funcionario.getNome());
			this.stmt.setString(2, funcionario.getSobrenome());
			this.stmt.setString(3, funcionario.getEmail());
			this.stmt.setString(4, funcionario.getCargo());
			this.stmt.setInt(5, funcionario.getIdSetor());
			this.stmt.executeUpdate();
			System.out.println("Funcionário inserido com sucesso!");			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo funcionário: " + e);
		}
	}

	public void update(Funcionario funcionario) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE usuario SET nome = ?, sobrenome = ?, email = ?, cargo=?  WHERE id = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbUpdate.toString());
			this.stmt.setString(1, funcionario.getNome());
			this.stmt.setString(2, funcionario.getSobrenome());
			this.stmt.setString(3, funcionario.getEmail());
			this.stmt.setString(4, funcionario.getCargo());
			this.stmt.setInt(5, funcionario.getId());
			this.stmt.executeUpdate();
			System.out.println("Funcionário alterado com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do func ionário. " + e);
		}
	}

	
}

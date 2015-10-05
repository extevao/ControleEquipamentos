package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Funcionario;



public class FuncionarioDao extends ConnectionFactory {

	public ArrayList<Funcionario> select (){
		ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Funcionario");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
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
		sbSelec.append("SELECT * FROM Funcionario WHERE id  = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
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
		sbInsert.append("INSERT INTO Funcionario (nome, sobrenome, email, cargo, idSetor) VALUES (?, ?, ?, ?, ?)");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, funcionario.getNome());
			this.stmtp.setString(2, funcionario.getSobrenome());
			this.stmtp.setString(3, funcionario.getEmail());
			this.stmtp.setString(4, funcionario.getCargo());
			this.stmtp.setInt(5, funcionario.getIdSetor());
			this.stmtp.executeUpdate();		
		} catch (SQLException e) {
			System.out.println("Erro ao inserir novo funcionário: " + e);
		}
	}

	public void update(Funcionario funcionario) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Funcionario SET nome = ?, sobrenome = ?, email = ?, cargo=?, idSetor=?  WHERE id = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, funcionario.getNome());
			this.stmtp.setString(2, funcionario.getSobrenome());
			this.stmtp.setString(3, funcionario.getEmail());
			this.stmtp.setString(4, funcionario.getCargo());
			this.stmtp.setInt(5, funcionario.getIdSetor());
			this.stmtp.setInt(6, funcionario.getId());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do funcionário. " + e);
		}
	}

	
}

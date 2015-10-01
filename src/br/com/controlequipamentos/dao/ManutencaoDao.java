package br.com.controlequipamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Manutencao;

public class ManutencaoDao {

	
	private Connection connection = ConnectionFactory.getConnection();
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ArrayList<Manutencao> select (){
		ArrayList<Manutencao> listaManutencao = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Manutencao");
		try {
			this.stmt = this.connection.prepareStatement(sbSelect.toString());
			this.rs = stmt.executeQuery();
			while (rs.next()) {	
				Manutencao manutencao = new Manutencao();
				manutencao.setId(rs.getInt("id"));
				manutencao.setDescricao(rs.getString("descricao"));
				manutencao.setMotivo(rs.getString("motivo"));
				manutencao.setDataInicio(rs.getDate("datainicio"));
				manutencao.setDataFim(rs.getDate("datafim"));
				manutencao.setIdEquipamento(rs.getInt("idEquipamento"));
				manutencao.setIdSetor(rs.getInt("idSetor"));
				manutencao.setIdFuncionario(rs.getInt("idFuncionario"));
				manutencao.setIdUsuario(rs.getInt("idUsuario"));
				
				listaManutencao.add(manutencao);
			}
			return listaManutencao;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Manutencao> selectId(int id) {
		ArrayList<Manutencao> listaManutencao = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM Manutencao WHERE id  = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbSelec.toString());
			this.stmt.setInt(1, id);
			this.rs = stmt.executeQuery();
			while (rs.next()) {
				Manutencao manutencao = new Manutencao();
				manutencao.setId(rs.getInt("id"));
				manutencao.setDescricao(rs.getString("descricao"));
				manutencao.setMotivo(rs.getString("motivo"));
				manutencao.setDataInicio(rs.getDate("datainicio"));
				manutencao.setDataFim(rs.getDate("datafim"));
				manutencao.setIdEquipamento(rs.getInt("idEquipamento"));
				manutencao.setIdSetor(rs.getInt("idSetor"));
				manutencao.setIdFuncionario(rs.getInt("idFuncionario"));
				manutencao.setIdUsuario(rs.getInt("idUsuario"));
				
				listaManutencao.add(manutencao);
			}
			return listaManutencao;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(Manutencao manutencao) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO Manutencao (descricao, motivo, datainicio, datafim, idEquipamento, idSetor, idFuncionario, idUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		try {
			this.stmt = this.connection.prepareStatement(sbInsert.toString());
			this.stmt.setString(1, manutencao.getDescricao());
			this.stmt.setString(2, manutencao.getMotivo());
			this.stmt.setDate(3, manutencao.getDataInicio());
			this.stmt.setDate(4, manutencao.getDataFim());
			this.stmt.setInt(5, manutencao.getIdEquipamento());
			this.stmt.setInt(6, manutencao.getIdSetor());
			this.stmt.setInt(7, manutencao.getIdFuncionario());
			this.stmt.setInt(8, manutencao.getIdSetor());
			this.stmt.executeUpdate();
				
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar uma nova manutenção: " + e);
		}
	}

	public void update(Manutencao manutencao) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Manutencao SET descricao = ?, motivo= ?, datainicio= ?, datafim=?, idEquipamento=?, idSetor=?, idFuncionario=?, idUsuario=?  WHERE id = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbUpdate.toString());
			this.stmt.setString(1, manutencao.getDescricao());
			this.stmt.setString(2, manutencao.getMotivo());
			this.stmt.setDate(3, manutencao.getDataInicio());
			this.stmt.setDate(4, manutencao.getDataFim());
			this.stmt.setInt(5, manutencao.getIdEquipamento());
			this.stmt.setInt(6, manutencao.getIdSetor());
			this.stmt.setInt(7, manutencao.getIdFuncionario());
			this.stmt.setInt(8, manutencao.getIdSetor());
			this.stmt.setInt(9, manutencao.getId());
			this.stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados da Manutenção: " + e);
		}
	}
	
}

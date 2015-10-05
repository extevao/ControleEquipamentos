package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Manutencao;

public class ManutencaoDao extends ConnectionFactory {
	
	public ArrayList<Manutencao> select (){
		ArrayList<Manutencao> listaManutencao = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Manutencao");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
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
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
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
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, manutencao.getDescricao());
			this.stmtp.setString(2, manutencao.getMotivo());
			this.stmtp.setDate(3, manutencao.getDataInicio());
			this.stmtp.setDate(4, manutencao.getDataFim());
			this.stmtp.setInt(5, manutencao.getIdEquipamento());
			this.stmtp.setInt(6, manutencao.getIdSetor());
			this.stmtp.setInt(7, manutencao.getIdFuncionario());
			this.stmtp.setInt(8, manutencao.getIdSetor());
			this.stmtp.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar uma nova manutenção: " + e);
		}
	}

	public void update(Manutencao manutencao) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Manutencao SET descricao = ?, motivo= ?, datainicio= ?, datafim=?, idEquipamento=?, idSetor=?, idFuncionario=?, idUsuario=?  WHERE id = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, manutencao.getDescricao());
			this.stmtp.setString(2, manutencao.getMotivo());
			this.stmtp.setDate(3, manutencao.getDataInicio());
			this.stmtp.setDate(4, manutencao.getDataFim());
			this.stmtp.setInt(5, manutencao.getIdEquipamento());
			this.stmtp.setInt(6, manutencao.getIdSetor());
			this.stmtp.setInt(7, manutencao.getIdFuncionario());
			this.stmtp.setInt(8, manutencao.getIdSetor());
			this.stmtp.setInt(9, manutencao.getId());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados da Manutenção: " + e);
		}
	}
	
}

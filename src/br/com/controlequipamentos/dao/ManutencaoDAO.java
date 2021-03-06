package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.ferramentas.ConversorData;
import br.com.controlequipamentos.pojo.Manutencao;

public class ManutencaoDAO extends ConnectionFactory {
	
	public ArrayList<Manutencao> select (){
		ArrayList<Manutencao> listaManutencoes = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Manutencao");
		ConversorData conversorData = new ConversorData();
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
			while (rs.next()) {	
				Manutencao manutencao = new Manutencao();
				manutencao.setId(rs.getString("id"));
				manutencao.setTitulo(rs.getString("titulo"));
				manutencao.setDescricao(rs.getString("descricao"));
				manutencao.setDataInicio(conversorData.converteDataDoMYSQL(rs.getString("data_inicio")));
				manutencao.setDataFim(conversorData.converteDataDoMYSQL(rs.getString("data_fim")));
				manutencao.setIdEquipamento(rs.getString("idEquipamento"));
				manutencao.setIdSetor(rs.getString("idSetor"));
				manutencao.setIdFuncionario(rs.getString("idFuncionario"));
				manutencao.setIdUsuario(rs.getString("idUsuario"));
				manutencao.setIdEstado(rs.getString("idEstado"));
				listaManutencoes.add(manutencao);
			}
			return listaManutencoes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Manutencao> selectId(int id) {
		ArrayList<Manutencao> listaManutencao = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM Manutencao WHERE id  = ?");
		ConversorData conversorData = new ConversorData();
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				Manutencao manutencao = new Manutencao();
				manutencao.setId(rs.getString("id"));
				manutencao.setTitulo(rs.getString("titulo"));
				manutencao.setDescricao(rs.getString("descricao"));
				manutencao.setDataInicio(conversorData.converteDataDoMYSQL(rs.getString("data_inicio")));
				manutencao.setDataFim(conversorData.converteDataDoMYSQL(rs.getString("data_fim")));
				manutencao.setIdEquipamento(rs.getString("idEquipamento"));
				manutencao.setIdSetor(rs.getString("idSetor"));
				manutencao.setIdFuncionario(rs.getString("idFuncionario"));
				manutencao.setIdUsuario(rs.getString("idUsuario"));
				manutencao.setIdEstado(rs.getString("idEstado"));
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
		sbInsert.append("INSERT INTO Manutencao (titulo, descricao, data_inicio, data_fim, idEquipamento, idSetor, idFuncionario, idUsuario, idEstado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		ConversorData conversorData = new ConversorData();
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, manutencao.getTitulo());
			this.stmtp.setString(2, manutencao.getDescricao());
			this.stmtp.setString(3, conversorData.converteDataParaMYSQL(manutencao.getDataInicio()));
			this.stmtp.setString(4, conversorData.converteDataParaMYSQL(manutencao.getDataFim()));
			this.stmtp.setString(5, manutencao.getIdEquipamento());
			this.stmtp.setString(6, manutencao.getIdSetor());
			this.stmtp.setString(7, manutencao.getIdFuncionario());
			this.stmtp.setString(8, manutencao.getIdUsuario());
			this.stmtp.setString(9, manutencao.getIdEstado());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar uma nova manutenção: " + e);
		}
	}

	public void update(Manutencao manutencao) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Manutencao SET titulo = ?, descricao= ?, data_inicio= ?, data_fim=?, idEquipamento=?, idSetor=?, idFuncionario=?, idUsuario=?, idEstado=?  WHERE id = ?");
		ConversorData conversorData = new ConversorData();
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, manutencao.getTitulo());
			this.stmtp.setString(2, manutencao.getDescricao());
			this.stmtp.setString(3, conversorData.converteDataParaMYSQL(manutencao.getDataInicio()));
			this.stmtp.setString(4, conversorData.converteDataParaMYSQL(manutencao.getDataFim()));
			this.stmtp.setString(5, manutencao.getIdEquipamento());
			this.stmtp.setString(6, manutencao.getIdSetor());
			this.stmtp.setString(7, manutencao.getIdFuncionario());
			this.stmtp.setString(8, manutencao.getIdUsuario());
			this.stmtp.setString(9, manutencao.getIdEstado());
			this.stmtp.setString(10, manutencao.getId());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados da Manutenção: " + e);
		}
	}
	
}

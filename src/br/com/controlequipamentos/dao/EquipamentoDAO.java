package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.ferramentas.ConversorData;
import br.com.controlequipamentos.pojo.Equipamento;

public class EquipamentoDAO extends ConnectionFactory {
	
	public ArrayList<Equipamento> select (){
		ArrayList<Equipamento>listaEquipamentos = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Equipamento");
		ConversorData conversorData = new ConversorData();
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
			while(this.rs.next()) {		
				Equipamento equipamento = new Equipamento();
				equipamento.setId(this.rs.getString("id"));
				equipamento.setNome(this.rs.getString("nome"));
				equipamento.setModelo(this.rs.getString("modelo"));
				equipamento.setDataInicio(conversorData.converteDataDoMYSQL(this.rs.getString("data_inicio")));
				equipamento.setDataFim(conversorData.converteDataDoMYSQL(this.rs.getString("data_fim")));
				equipamento.setServstag(this.rs.getString("servstag"));
				equipamento.setPatrimonio(this.rs.getString("patrimonio"));
				equipamento.setIdCategoria(this.rs.getString("idCategoria"));
				equipamento.setIdMarca(this.rs.getString("idMarca"));
				equipamento.setIdSetor(this.rs.getString("idSetor"));
				equipamento.setIdFuncionario(this.rs.getString("idFuncionario"));
				equipamento.setIdRequisito(this.rs.getString("idRequisito"));
				equipamento.setIdEstado(this.rs.getString("idEstado"));
				listaEquipamentos.add(equipamento);
			}
			return listaEquipamentos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Equipamento> selectId(int id) {
		ArrayList<Equipamento> listaEquipamento = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM Equipamento WHERE id  = ?");
		ConversorData conversorData = new ConversorData();
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				Equipamento equipamento = new Equipamento();
				equipamento.setId(this.rs.getString("id"));
				equipamento.setNome(this.rs.getString("nome"));
				equipamento.setModelo(this.rs.getString("modelo"));
				equipamento.setDataInicio(conversorData.converteDataDoMYSQL(this.rs.getString("data_inicio")));
				equipamento.setDataFim(conversorData.converteDataDoMYSQL(this.rs.getString("data_fim")));
				equipamento.setServstag(this.rs.getString("servstag"));
				equipamento.setPatrimonio(this.rs.getString("patrimonio"));
				equipamento.setIdCategoria(this.rs.getString("idCategoria"));
				equipamento.setIdMarca(this.rs.getString("idMarca"));
				equipamento.setIdSetor(this.rs.getString("idSetor"));
				equipamento.setIdFuncionario(this.rs.getString("idFuncionario"));
				equipamento.setIdRequisito(this.rs.getString("idRequisito"));
				equipamento.setIdEstado(this.rs.getString("idEstado"));
				listaEquipamento.add(equipamento);
			}
			return listaEquipamento;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(Equipamento equipamento) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO Equipamento SET nome=?, modelo=?, data_inicio=?, data_fim=?, servstag=?, patrimonio=?, idCategoria=?, idMarca=?, idSetor=?, idFuncionario=?, idRequisito=?, idEstado=? ");
		ConversorData conversorData = new ConversorData();
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, equipamento.getNome());
			this.stmtp.setString(2, equipamento.getModelo());
			this.stmtp.setString(3, conversorData.converteDataParaMYSQL(equipamento.getDataInicio()));
			this.stmtp.setString(4, conversorData.converteDataParaMYSQL(equipamento.getDataFim()));
			this.stmtp.setString(5, equipamento.getServstag());
			this.stmtp.setString(6, equipamento.getPatrimonio());			
			this.stmtp.setString(7, equipamento.getIdCategoria());
			this.stmtp.setString(8, equipamento.getIdMarca());
			this.stmtp.setString(9, equipamento.getIdSetor());
			this.stmtp.setString(10, equipamento.getIdFuncionario());
			this.stmtp.setString(11, equipamento.getIdRequisito());
			this.stmtp.setString(12, equipamento.getIdEstado());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar o novo Equipamento: " + e);
			
		}
	}
	public void update(Equipamento equipamento) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Equipamento SET nome=?, modelo=?, data_inicio=?, data_fim=?, servstag=?, patrimonio=?, idCategoria=?, idMarca=?, idSetor=?, idFuncionario=?, idRequisito=?, idEstado=?  WHERE id = ? ");
		ConversorData conversorData = new ConversorData();
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, equipamento.getNome());
			this.stmtp.setString(2, equipamento.getModelo());
			this.stmtp.setString(3, conversorData.converteDataParaMYSQL(equipamento.getDataInicio()));
			this.stmtp.setString(4, conversorData.converteDataParaMYSQL(equipamento.getDataFim()));
			this.stmtp.setString(5, equipamento.getServstag());
			this.stmtp.setString(6, equipamento.getPatrimonio());			
			this.stmtp.setString(7, equipamento.getIdCategoria());
			this.stmtp.setString(8, equipamento.getIdMarca());
			this.stmtp.setString(9, equipamento.getIdSetor());
			this.stmtp.setString(10, equipamento.getIdFuncionario());
			this.stmtp.setString(11, equipamento.getIdRequisito());
			this.stmtp.setString(12, equipamento.getIdEstado());
			this.stmtp.setString(13, equipamento.getId());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do Equipamento: " + e);
			
		}
	}

}

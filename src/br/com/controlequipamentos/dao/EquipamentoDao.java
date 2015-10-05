package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Equipamento;

public class EquipamentoDao extends ConnectionFactory {
	
	public ArrayList<Equipamento> select (){
		ArrayList<Equipamento>listaEquipamento = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Equipamento");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
			while(this.rs.next()) {	
				Equipamento equipamento = new Equipamento();
				equipamento.setId(this.rs.getInt("id"));
				equipamento.setNome(this.rs.getString("nome"));
				equipamento.setDataCompra(this.rs.getDate("datacompra"));
				equipamento.setDataCadastro(this.rs.getDate("datacadastro"));
				equipamento.setDataInicioOperacao(this.rs.getDate("datainiciooperacao"));
				equipamento.setMarca(this.rs.getString("marca"));
				equipamento.setIdCategoria(this.rs.getInt("idCategoria"));
				equipamento.setIdSetor(this.rs.getInt("idSetor"));
				equipamento.setIdFuncionario(this.rs.getInt("idFuncionario"));
				equipamento.setIdRequisito(this.rs.getInt("idRequisito"));
				
				listaEquipamento.add(equipamento);
			}
			return listaEquipamento;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Equipamento> selectId(int id) {
		ArrayList<Equipamento> listaEquipamento = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM Equipamento WHERE id  = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				Equipamento equipamento = new Equipamento();
				equipamento.setId(this.rs.getInt("id"));
				equipamento.setNome(this.rs.getString("nome"));
				equipamento.setDataCompra(this.rs.getDate("datacompra"));
				equipamento.setDataCadastro(this.rs.getDate("datacadastro"));
				equipamento.setDataInicioOperacao(this.rs.getDate("datainiciooperacao"));
				equipamento.setMarca(this.rs.getString("marca"));
				equipamento.setIdCategoria(this.rs.getInt("idCategoria"));
				equipamento.setIdSetor(this.rs.getInt("idSetor"));
				equipamento.setIdFuncionario(this.rs.getInt("idFuncionario"));
				equipamento.setIdRequisito(this.rs.getInt("idRequisito"));
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
		sbInsert.append("INSERT INTO Equipamento SET nome=?, data=?, datacadastro=?, datainiciooperacao=?, marca=?, idCategoria=?, idSetor=?, idFuncionario=?, idRequisito=? ");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, equipamento.getNome());
			this.stmtp.setDate(2, equipamento.getDataCompra());
			this.stmtp.setDate(3, equipamento.getDataCadastro());
			this.stmtp.setDate(4, equipamento.getDataInicioOperacao());
			this.stmtp.setString(5, equipamento.getMarca());
			this.stmtp.setInt(6, equipamento.getIdCategoria());
			this.stmtp.setInt(7, equipamento.getIdSetor());
			this.stmtp.setInt(8, equipamento.getIdFuncionario());
			this.stmtp.setInt(9, equipamento.getIdRequisito());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar o novo Equipamento: " + e);
			
		}
	}
	public void update(Equipamento equipamento) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Equipamento SET nome=?, data=?, datacadastro=?, datainiciooperacao=?, marca=?, idCategoria=?, idSetor=?, idFuncionario=?, idRequisito=?  WHERE id = ? ");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, equipamento.getNome());
			this.stmtp.setDate(2, equipamento.getDataCompra());
			this.stmtp.setDate(3, equipamento.getDataCadastro());
			this.stmtp.setDate(4, equipamento.getDataInicioOperacao());
			this.stmtp.setString(5, equipamento.getMarca());
			this.stmtp.setInt(6, equipamento.getIdCategoria());
			this.stmtp.setInt(7, equipamento.getIdSetor());
			this.stmtp.setInt(8, equipamento.getIdFuncionario());
			this.stmtp.setInt(9, equipamento.getIdRequisito());
			this.stmtp.setInt(10, equipamento.getId());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do Equipamento: " + e);
			
		}
	}

}

package br.com.controlequipamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Equipamento;

public class EquipamentoDao {

	private Connection connection = ConnectionFactory.getConnection();
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ArrayList<Equipamento> select (){
		ArrayList<Equipamento>listaEquipamento = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Equipamento");
		try {
			this.stmt = this.connection.prepareStatement(sbSelect.toString());
			this.rs = stmt.executeQuery();
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
			this.stmt = this.connection.prepareStatement(sbSelec.toString());
			this.stmt.setInt(1, id);
			this.rs = stmt.executeQuery();
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
			
			this.stmt = this.connection.prepareStatement(sbInsert.toString());
			this.stmt.setString(1, equipamento.getNome());
			this.stmt.setDate(2, equipamento.getDataCompra());
			this.stmt.setDate(3, equipamento.getDataCadastro());
			this.stmt.setDate(4, equipamento.getDataInicioOperacao());
			this.stmt.setString(5, equipamento.getMarca());
			this.stmt.setInt(6, equipamento.getIdCategoria());
			this.stmt.setInt(7, equipamento.getIdSetor());
			this.stmt.setInt(8, equipamento.getIdFuncionario());
			this.stmt.setInt(9, equipamento.getIdRequisito());
		
			
			this.stmt.executeUpdate();
			System.out.println("Equipamento cadastrado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar o novo Equipamento: " + e);
			
		}
	}
	public void update(Equipamento equipamento) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Equipamento SET nome=?, data=?, datacadastro=?, datainiciooperacao=?, marca=?, idCategoria=?, idSetor=?, idFuncionario=?, idRequisito=?  WHERE id = ? ");
		try {
			
			this.stmt = this.connection.prepareStatement(sbUpdate.toString());
			this.stmt.setString(1, equipamento.getNome());
			this.stmt.setDate(2, equipamento.getDataCompra());
			this.stmt.setDate(3, equipamento.getDataCadastro());
			this.stmt.setDate(4, equipamento.getDataInicioOperacao());
			this.stmt.setString(5, equipamento.getMarca());
			this.stmt.setInt(6, equipamento.getIdCategoria());
			this.stmt.setInt(7, equipamento.getIdSetor());
			this.stmt.setInt(8, equipamento.getIdFuncionario());
			this.stmt.setInt(9, equipamento.getIdRequisito());
			this.stmt.setInt(10, equipamento.getId());
			
			this.stmt.executeUpdate();
			System.out.println("Equipamento alterado com sucesso!");
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do Equipamento: " + e);
			
		}
	}

}

package br.com.controlequipamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Requisito;

public class RequisitoDao {
	
	
	
	private Connection connection = ConnectionFactory.getConnection();
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ArrayList<Requisito> select (){
		ArrayList<Requisito> listaRequisitos = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Requisito");
		try {
			this.stmt = this.connection.prepareStatement(sbSelect.toString());
			this.rs = stmt.executeQuery();
			while (rs.next()) {	
				Requisito requisito = new Requisito();
				requisito.setId(rs.getInt("id"));
				requisito.setProcessador(rs.getString("processador"));
				requisito.setMemoriaram(rs.getString("memoriaram"));
				requisito.setHd(rs.getString("hd"));
				requisito.setVideo(rs.getString("video"));
				
				listaRequisitos.add(requisito);
			}
			return listaRequisitos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Requisito> selectId(int id) {
		ArrayList<Requisito> listaRequisito = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM Requisito WHERE id  = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbSelec.toString());
			this.stmt.setInt(1, id);
			this.rs = stmt.executeQuery();
			while (rs.next()) {
				Requisito requisito = new Requisito();
				requisito.setId(rs.getInt("id"));
				requisito.setProcessador(rs.getString("processador"));
				requisito.setMemoriaram(rs.getString("memoriaram"));
				requisito.setHd(rs.getString("hd"));
				requisito.setVideo(rs.getString("video"));
				
				listaRequisito.add(requisito);
			}
			return listaRequisito;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(Requisito requisito) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO Requisito (processador, memoriaram, hd, video) VALUES (?, ?, ?, ?)");
		try {
			this.stmt = this.connection.prepareStatement(sbInsert.toString());
			this.stmt.setString(1, requisito.getProcessador());
			this.stmt.setString(2, requisito.getMemoriaram());
			this.stmt.setString(3, requisito.getHd());
			this.stmt.setString(4, requisito.getVideo());
			this.stmt.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o novo requisito: " + e);
		}
	}

	public void update(Requisito requisito) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Requisito SET processador = ?, memoriaram = ?, hd= ?, video=?  WHERE id = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbUpdate.toString());
			this.stmt.setString(1, requisito.getProcessador());
			this.stmt.setString(2, requisito.getMemoriaram());
			this.stmt.setString(3, requisito.getHd());
			this.stmt.setString(4, requisito.getVideo());
			this.stmt.setInt(5, requisito.getId());
			this.stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do requisito. " + e);
		}
	}

}

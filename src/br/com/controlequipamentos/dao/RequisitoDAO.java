package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Requisito;

public class RequisitoDAO extends ConnectionFactory {
	
	public ArrayList<Requisito> select (){
		ArrayList<Requisito> listaRequisitos = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Requisito");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
			while (rs.next()) {	
				Requisito requisito = new Requisito();
				requisito.setId(rs.getInt("id"));
				requisito.setProcessador(rs.getString("processador"));
				requisito.setFrequencia(rs.getString("frequencia"));
				requisito.setNumeroNucleos(rs.getString("numero_nucleos"));
				requisito.setMemoria(rs.getString("memoria"));
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
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				Requisito requisito = new Requisito();
				requisito.setId(rs.getInt("id"));
				requisito.setProcessador(rs.getString("processador"));
				requisito.setFrequencia(rs.getString("frequencia"));
				requisito.setNumeroNucleos(rs.getString("numero_nucleos"));
				requisito.setMemoria(rs.getString("memoria"));
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
		sbInsert.append("INSERT INTO Requisito (processador, frequencia, numero_nucleos, memoria, hd, video) VALUES (?, ?, ?, ?, ?)");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, requisito.getProcessador());
			this.stmtp.setString(2, requisito.getFrequencia());
			this.stmtp.setString(3, requisito.getNumeroNucleos());
			this.stmtp.setString(4, requisito.getMemoria());
			this.stmtp.setString(5, requisito.getHd());
			this.stmtp.setString(6, requisito.getVideo());
			this.stmtp.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o novo requisito: " + e);
		}
	}

	public void update(Requisito requisito) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Requisito SET processador = ?, frequencia = ?, numero_nucleos = ?, memoria = ?, hd= ?, video=?  WHERE id = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, requisito.getProcessador());
			this.stmtp.setString(2, requisito.getFrequencia());
			this.stmtp.setString(3, requisito.getNumeroNucleos());
			this.stmtp.setString(4, requisito.getMemoria());
			this.stmtp.setString(5, requisito.getHd());
			this.stmtp.setString(6, requisito.getVideo());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do requisito. " + e);
		}
	}

}

package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Setor;

public class SetorDAO extends ConnectionFactory {
	
	public ArrayList<Setor> select (){
		ArrayList<Setor> listaSetores = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Setor");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
			while (rs.next()) {	
				Setor setor = new Setor();
				setor.setId(rs.getString("id"));
				setor.setNome(rs.getString("nome"));
				setor.setIdStatus(rs.getString("idStatus"));
				setor.setIdRequisito(rs.getString("idRequisito"));
				
				listaSetores.add(setor);
			}
			return listaSetores;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Setor> selectId(int id) {
		ArrayList<Setor> listaSetor = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM Setor WHERE id  = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				Setor setor = new Setor();
				setor.setId(rs.getString("id"));
				setor.setNome(rs.getString("nome"));
				setor.setIdStatus(rs.getString("idStatus"));
				setor.setIdRequisito(rs.getString("idRequisito"));
				listaSetor.add(setor);
			}
			return listaSetor;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(Setor setor) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO Setor (nome, idStatus, idRequisito) VALUES (?, ?, ?)");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, setor.getNome());
			this.stmtp.setString(2, setor.getIdStatus());
			this.stmtp.setString(3, setor.getIdRequisito());
			this.stmtp.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("Erro ao inserir o novo setor !!! " + e);
		}
	}

	public void update(Setor setor) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Setor SET nome = ?, idStatus = ?, idRequisito=?  WHERE id = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, setor.getNome());
			this.stmtp.setString(2, setor.getIdStatus());
			this.stmtp.setString(3, setor.getIdRequisito());
			this.stmtp.setString(4, setor.getId());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erro ao alterar os dados do setor !!! " + e);
		}
	}

}

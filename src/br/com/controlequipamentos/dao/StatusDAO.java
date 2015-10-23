package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Status;

public class StatusDAO extends ConnectionFactory{
	
	public ArrayList<Status> select() {
		ArrayList<Status> listaStatus = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Status");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
			while (this.rs.next()) {
				Status  status = new Status();
				status .setId(rs.getInt("id"));
				status .setNome(rs.getString("nome"));
				listaStatus.add(status );
			}
			return listaStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Status> selectId(int idStatus) {
		ArrayList<Status> listaStatus = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM Status WHERE id  = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, idStatus);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				Status status = new Status();
				status.setId(rs.getInt("id"));
				status.setNome(rs.getString("nome"));
				listaStatus.add(status);
			}
			return listaStatus;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Status Status) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO Status SET nome= ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, Status.getNome());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Houve um erro ao tentar salvar a nova Status: " + e);

		}
	}
	public void update(Status Status) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Status SET nome = ?  WHERE id = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, Status.getNome());
			this.stmtp.setInt(2, Status.getId());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar alterar a Status: " + e);
		}
	}

}

package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Estado;

public class EstadoDAO extends ConnectionFactory {
	
	public ArrayList<Estado> select() {
		ArrayList<Estado> listaestados = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Estado");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
			while (this.rs.next()) {
				Estado estado = new Estado();
				estado.setId(rs.getString("id"));
				estado.setNome(rs.getString("nome"));
				listaestados.add(estado);
			}
			return listaestados;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Estado> selectId(int idestado) {
		ArrayList<Estado> listaestado = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM Estado WHERE id  = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, idestado);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				Estado estado = new Estado();
				estado.setId(rs.getString("id"));
				estado.setNome(rs.getString("nome"));
				listaestado.add(estado);
			}
			return listaestado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Estado estado) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO Estado SET nome= ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, estado.getNome());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Houve um erro ao tentar salvar: " + e);

		}
	}
	public void update(Estado estado) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Estado SET nome = ?  WHERE id = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, estado.getNome());
			this.stmtp.setString(2, estado.getId());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar alterar os dados do estado: " + e);
		}
	}
	
}

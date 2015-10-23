package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Marca;

public class MarcaDAO extends ConnectionFactory {


	public ArrayList<Marca> select() {
		ArrayList<Marca> listamarcas = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Marca");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
			while (this.rs.next()) {
				Marca marca = new Marca();
				marca.setId(rs.getInt("id"));
				marca.setNome(rs.getString("nome"));
				listamarcas.add(marca);
			}
			return listamarcas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Marca> selectId(int idmarca) {
		ArrayList<Marca> listamarca = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM marca WHERE id  = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, idmarca);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				Marca marca = new Marca();
				marca.setId(rs.getInt("id"));
				marca.setNome(rs.getString("nome"));
				listamarca.add(marca);
			}
			return listamarca;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Marca marca) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO marca SET nome= ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, marca.getNome());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Houve um erro ao tentar salvar a nova marca: " + e);

		}
	}
	public void update(Marca marca) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE marca SET nome = ?  WHERE id = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, marca.getNome());
			this.stmtp.setInt(2, marca.getId());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar alterar a marca: " + e);
		}
	}

}

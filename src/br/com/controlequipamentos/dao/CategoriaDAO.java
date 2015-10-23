package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Categoria;

public class CategoriaDAO extends ConnectionFactory {

	public ArrayList<Categoria> select() {
		ArrayList<Categoria> listaCategoria = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM Categoria");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelect.toString());
			this.rs = stmtp.executeQuery();
			while (this.rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setNome(rs.getString("nome"));
				listaCategoria.add(categoria);
			}
			return listaCategoria;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Categoria> selectId(int idCategoria) {
		ArrayList<Categoria> listaCategoria = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM Categoria WHERE id  = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, idCategoria);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				Categoria categoria = new Categoria();
				categoria.setId(rs.getInt("id"));
				categoria.setNome(rs.getString("nome"));
				listaCategoria.add(categoria);
			}
			return listaCategoria;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Categoria categoria) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO Categoria SET nome= ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbInsert.toString());
			this.stmtp.setString(1, categoria.getNome());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Houve um erro ao tentar salvar a nova Categoria: " + e);

		}
	}
	public void update(Categoria categoria) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE Categoria SET nome = ?  WHERE id = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbUpdate.toString());
			this.stmtp.setString(1, categoria.getNome());
			this.stmtp.setInt(2, categoria.getId());
			this.stmtp.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar alterar a categoria: " + e);
		}
	}

}

package br.com.controlequipamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Categoria;


public class CategoriaDao {
	
	private Connection connection = ConnectionFactory.getConnection();
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//Método para listar todas as categorias existentes
	public ArrayList<Categoria> select (){
		ArrayList<Categoria>listaCategoria = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM categoria");
		try {
			this.stmt = this.connection.prepareStatement(sbSelect.toString());
			this.rs = stmt.executeQuery();
			while(this.rs.next()) {	
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
	//Método para pesquisar a categoria por id
	public ArrayList<Categoria> selectId(int idCategoria) {
		ArrayList<Categoria> listaCategoria = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT * FROM categoria WHERE id  = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbSelec.toString());
			this.stmt.setInt(1, idCategoria);
			this.rs = stmt.executeQuery();
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
	
	//Método para inserir uma nova categoria
	

	public String salvar (Categoria categoria){
		try{
			if(categoria.getId() == 0){
				insert(categoria);
			}else{
				update(categoria);
			}
			 return "ok";
		}catch(Exception e){
			e.printStackTrace();
			return "não";
		}
		  
	}	
	public void insert(Categoria categoria) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO categoria SET nome= ?");
		try {
			
			this.stmt = this.connection.prepareStatement(sbInsert.toString());
			this.stmt.setString(1, categoria.getNome());
			this.stmt.executeUpdate();
			System.out.println("Categoria inserida com sucesso!");

			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Categoria: " + e);
			
		}
	}

	public void update(Categoria categoria) {
		StringBuilder sbUpdate = new StringBuilder();
		sbUpdate.append("UPDATE categoria SET nome = ?  WHERE id = ?");
		try {
			this.stmt = this.connection.prepareStatement(sbUpdate.toString());
			this.stmt.setString(1, categoria.getNome());			
			this.stmt.executeUpdate();
			System.out.println("Categoria alterada com sucesso.");
		} catch (SQLException e) {
			System.out.println("Erro ao alterar a categoria. "+ e);
		}
	}

	
	

}

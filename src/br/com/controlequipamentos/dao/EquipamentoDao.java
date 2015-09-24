package br.com.controlequipamentos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Equipamento;

public class EquipamentoDao {

	private Connection connection = ConnectionFactory.getConnection();
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ArrayList<Equipamento> select (){
		ArrayList<Equipamento>listaEquipamento = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM categoria");
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
			
			
				
				listaEquipamento.add(equipamento);
			}
			return listaEquipamento;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}

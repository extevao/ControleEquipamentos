package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;


import br.com.controlequipamentos.pojo.ManutencaoEquipamento;

public class ManutencaoEquipamentoDAO extends ConnectionFactory{

	
	
	
	
	public ArrayList<ManutencaoEquipamento> selectEquipamentoPorCategoria(int id) {
		ArrayList<ManutencaoEquipamento> listaManutencaoPorEquipamento = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("Select "
				+ "mnt.titulo,"
				+ "mnt.descricao,"
				+ "eqp.modelo,"
				+ "mrc.nome Marca "
				+ "From manutencao mnt "
				+ "LEFT OUTER JOIN "
				+ "equipamento eqp on eqp.id = mnt.idEquipamento "
				+ "LEFT OUTER JOIN "
				+ "marca mrc on mrc.id = eqp.idMarca "
				+ "WHERE eqp.id = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				ManutencaoEquipamento manutencao = new ManutencaoEquipamento();
				
				manutencao.setTitulo(this.rs.getString("titulo"));
				manutencao.setDescricao(this.rs.getString("descricao"));
				manutencao.setModelo(this.rs.getString("modelo"));
				manutencao.setMarca(this.rs.getString("Marca"));
				listaManutencaoPorEquipamento.add(manutencao);
			}
			return listaManutencaoPorEquipamento;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

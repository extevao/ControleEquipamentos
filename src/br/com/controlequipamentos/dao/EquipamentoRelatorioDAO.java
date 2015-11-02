package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.ferramentas.ConversorData;
import br.com.controlequipamentos.pojo.Categoria;
import br.com.controlequipamentos.pojo.Equipamento;
import br.com.controlequipamentos.pojo.EquipamentoRelatorio;

public class EquipamentoRelatorioDAO  extends ConnectionFactory{

	
	public ArrayList<EquipamentoRelatorio> selectEquipamentoPorCategoria() {
		ArrayList<EquipamentoRelatorio> listaEquipamento = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("SELECT epq.idCategoria, ctg.nome categoria, epq.modelo  FROM Equipamento epq INNER JOIN categoria ctg on ctg.id = epq.idCategoria ");
	
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				EquipamentoRelatorio equipamento = new EquipamentoRelatorio();
				equipamento.setIdCategoria(this.rs.getInt("idCategoria"));
				equipamento.setCategoria(this.rs.getString("categoria"));
				equipamento.setModelo(this.rs.getString("modelo"));
				listaEquipamento.add(equipamento);
			}
			return listaEquipamento;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

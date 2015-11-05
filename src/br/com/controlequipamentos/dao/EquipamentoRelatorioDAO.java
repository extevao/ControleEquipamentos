package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.Equipamento;


public class EquipamentoRelatorioDAO  extends ConnectionFactory{

	
	public ArrayList<Equipamento> selectEquipamentoPorCategoria(int id) {
		ArrayList<Equipamento> listaEquipamento = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("Select "
				+ "eqp.idCategoria,"
				+ "eqp.modelo,"
				+ "eqp.nome equipamento_nome,"
				+ "eqp.servstag,"
				+ "eqp.patrimonio,"
				+ "ctg.nome categoria,"
				+ "mrc.nome marca,"
				+ "str.nome setor,"
				+ "est.nome estado_esquipamento "
				+ "From equipamento eqp "
				+ "LEFT OUTER JOIN "
				+ "categoria ctg on ctg.id = eqp.idCategoria "
				+ "LEFT OUTER JOIN "
				+ "marca mrc on mrc.id = eqp.idMarca "
				+ "LEFT OUTER JOIN "
				+ "setor str on str.id = eqp.idSetor "
				+ "LEFT OUTER JOIN "
				+ "estado est on est.id = eqp.idEstado");
	
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				Equipamento equipamento = new Equipamento();
				equipamento.setModelo(this.rs.getString("modelo"));
				equipamento.setNome(this.rs.getString("equipamento_nome"));
				equipamento.setServstag(this.rs.getString("servstag"));
				equipamento.setPatrimonio(this.rs.getString("patrimonio"));
				equipamento.setIdCategoria(this.rs.getString("idCategoria"));
				equipamento.setIdMarca(this.rs.getString("marca"));
				equipamento.setIdSetor(this.rs.getString("setor"));
				equipamento.setIdEstado(this.rs.getString("estado_esquipamento"));		
				listaEquipamento.add(equipamento);
			}
			return listaEquipamento;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

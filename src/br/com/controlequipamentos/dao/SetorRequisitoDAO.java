package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.pojo.SetorRequisito;

public class SetorRequisitoDAO extends ConnectionFactory {

	public ArrayList<SetorRequisito> selectListaRequisitoSetor() {
		ArrayList<SetorRequisito> listaRequsitoSetor = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("Select "
				+ "str.nome setor, "
				+ "req.processador, "
				+ "req.memoria, "
				+ "req.hd  "
				+ "From setor str "
				+ "LEFT OUTER JOIN " 
				+ "requisito req on req.id = str.idRequisito ");
		try {
			
				this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			
				this.rs = stmtp.executeQuery();
				while (rs.next()) {
					SetorRequisito reqSetor= new SetorRequisito();
					reqSetor.setSetor(this.rs.getString("setor"));
					reqSetor.setProcessador(this.rs.getString("processador"));
					reqSetor.setMemoria(this.rs.getString("memoria"));
					reqSetor.setHd(this.rs.getString("hd"));
				
					listaRequsitoSetor.add(reqSetor);
				}
				return listaRequsitoSetor;
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}
}

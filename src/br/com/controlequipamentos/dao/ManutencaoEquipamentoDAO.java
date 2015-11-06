package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.ferramentas.ConversorData;
import br.com.controlequipamentos.pojo.ManutencaoEquipamento;

public class ManutencaoEquipamentoDAO extends ConnectionFactory{

	
	
	
	
	public ArrayList<ManutencaoEquipamento> selectManutencaoEquipamento(int id) {
		ArrayList<ManutencaoEquipamento> listaManutencaoEquipamento = new ArrayList<>();
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("Select "
				+ "mnt.titulo,"
				+ "mnt.descricao,"
				+ "mnt.data_inicio, "
				+ "mnt.data_fim, "
				+ "DATEDIFF (mnt.data_fim, mnt.data_inicio)  tempo_manutencao, "
				+ "eqp.modelo, "
				+ "mrc.nome Marca, "
				+ "est.nome estado, "
				+ "usr.nome usuario, "
				+ "fun.nome funcionario_maquina, "
				+ "str.nome setor "
				+ "From manutencao mnt "
				+ "LEFT OUTER JOIN "
				+ "equipamento eqp on eqp.id = mnt.idEquipamento "
				+ "LEFT OUTER JOIN "
				+ "marca mrc on mrc.id = eqp.idMarca "
				+ "LEFT OUTER JOIN "
				+ "estado est on est.id = mnt.idEstado "
				+ "LEFT OUTER JOIN "
				+ "usuario usr on usr.id = mnt.idUsuario "
				+ "LEFT OUTER JOIN "
				+ "funcionario fun on fun.id = mnt.idFuncionario "
				+ "LEFT OUTER JOIN "
				+ "setor str on str.id = mnt.idSetor "
				+ "WHERE eqp.id = ?");
		ConversorData conversorData = new ConversorData();
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setInt(1, id);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				ManutencaoEquipamento manutencao = new ManutencaoEquipamento();
				manutencao.setTitulo(this.rs.getString("titulo"));
				manutencao.setDescricao(this.rs.getString("descricao"));
				manutencao.setDataInicio(conversorData.converteDataDoMYSQL(rs.getString("data_inicio")));
				manutencao.setDataFim(conversorData.converteDataDoMYSQL(rs.getString("data_fim")));
				manutencao.setTempoManutencao(this.rs.getString("tempo_manutencao"));
				manutencao.setModelo(this.rs.getString("modelo"));
				manutencao.setMarca(this.rs.getString("Marca"));
				manutencao.setEstadoManutencao(this.rs.getString("estado"));
				manutencao.setUsuario(this.rs.getString("usuario"));
				manutencao.setFuncionarioMaquina(this.rs.getString("funcionario_maquina"));
				manutencao.setSetor(this.rs.getString("setor"));
				listaManutencaoEquipamento.add(manutencao);
			}
			return listaManutencaoEquipamento;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}

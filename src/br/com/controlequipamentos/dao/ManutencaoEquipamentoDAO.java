package br.com.controlequipamentos.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.controlequipamentos.ferramentas.ConversorData;
import br.com.controlequipamentos.ferramentas.Media;
import br.com.controlequipamentos.pojo.ManutencaoEquipamento;
import br.com.controlequipamentos.pojo.Marca;
import br.com.controlequipamentos.pojo.RelatorioGeralManutencaoMarca;

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
	
	public RelatorioGeralManutencaoMarca relatorioGeralManutencao(String idMarca) {
		
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("Select "
				+ "mrc.id, "
				+ "mrc.nome marca, "
				+ "COUNT(mnt.titulo) qtdManutencao, "
				+ "SUM(DATEDIFF(mnt.data_FIM, mnt.data_inicio))tempo_manutencao "
				+ "From manutencao mnt "
				+ "LEFT OUTER JOIN "
				+ "equipamento eqp on eqp.id = mnt.idEquipamento "
				+ "LEFT OUTER JOIN "
				+ "marca mrc on mrc.id = eqp.idMarca "
				+ "WHERE mrc.id = ?");
		RelatorioGeralManutencaoMarca manutencao = new RelatorioGeralManutencaoMarca();
		
		try {
			Media tMedia = new Media();
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setString(1, idMarca);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				manutencao.setIdMarca(this.rs.getString("id"));
				manutencao.setMarca(this.rs.getString("marca"));
				manutencao.setQtdManutencao(this.rs.getString("qtdManutencao"));
				manutencao.setTempoManutencao(this.rs.getString("tempo_manutencao"));
				manutencao.setQtdEquipamento(selectQtdEquipamento(idMarca));
				manutencao.setMediaManutencaoEquipamento(tMedia.media(manutencao.getQtdManutencao(),selectQtdEquipamento(idMarca)));
				manutencao.setMediaTempoManutencao((tMedia.media(manutencao.getTempoManutencao(),manutencao.getQtdManutencao())));
			}
			
			return manutencao;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<RelatorioGeralManutencaoMarca> listaRelatorioGeralManutencaoMarca() {
		
		MarcaDAO marcaDAO = new MarcaDAO();
		ArrayList<RelatorioGeralManutencaoMarca> listaManutencaoEquipamento = new ArrayList<>();
		for(Marca obj : marcaDAO.verificaQtdMarca()){
			
			listaManutencaoEquipamento.add(relatorioGeralManutencao(obj.getId()));
		}
		
		return listaManutencaoEquipamento;		
		
	}
	public String selectQtdEquipamento(String idMarca) {
		String qtdEquipamentos = null;
		StringBuilder sbSelec = new StringBuilder();
		sbSelec.append("Select "
				+ "COUNT(eqp.modelo) qtdEquipamentos "						
				+ "From equipamento eqp "
				+ "WHERE eqp.idMarca = ?");
		try {
			this.stmtp = this.getConnection().prepareStatement(sbSelec.toString());
			this.stmtp.setString(1, idMarca);
			this.rs = stmtp.executeQuery();
			while (rs.next()) {
				qtdEquipamentos = this.rs.getString("qtdEquipamentos");
			}
			return qtdEquipamentos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qtdEquipamentos;
	}
	
}

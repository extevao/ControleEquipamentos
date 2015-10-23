package pacoteTeste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.controlequipamentos.ferramentas.ConversorData;

public class PraticandoComDatas { // Classe para praticar a inserção de datas no banco, assim como as suas alterações
									
	public static void main(String[] args) {
		
		DatasPojo data = new DatasPojo();
		data.setNome("Teste data inserida com conversor");
		data.setPrimeiraData("09/10/2015");
		data.setSegundaData("11/12/2016");
		inserir(data);
		listar();
	}

	public static void inserir(DatasPojo algo) {
		StringBuilder sbInsert = new StringBuilder();
		sbInsert.append("INSERT INTO tstdata SET nome= ?, primeira_data=?, segunda_data=?");
		try {
			ConversorData conversorData = new ConversorData();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/base", "root", "");
			PreparedStatement stmtp = con.prepareStatement(sbInsert.toString());
			stmtp = con.prepareStatement(sbInsert.toString());
			stmtp.setString(1, algo.getNome());
			stmtp.setString(2, conversorData.converteDataParaMYSQL(algo.getPrimeiraData()));
			stmtp.setString(3, conversorData.converteDataParaMYSQL(algo.getSegundaData()));
			stmtp.executeUpdate();
			System.out.println("Acho que foi !!!");
		} catch (SQLException e) {
			System.out.println("Houve um erro ao tentar salvar a data: " + e);

		}
	}

	
	public static void listar() {
		ArrayList<DatasPojo> listaDatas = new ArrayList<>();
		StringBuilder sbSelect = new StringBuilder();
		sbSelect.append("SELECT * FROM tstdata");

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/base", "root", "");
			PreparedStatement stmt = con.prepareStatement(sbSelect.toString());
			ResultSet rs = stmt.executeQuery();
			ConversorData conversorData = new ConversorData();
			while (rs.next()) {
				DatasPojo data = new DatasPojo();
				data.setId(rs.getInt("id"));
				data.setNome(rs.getString("nome"));
				data.setPrimeiraData(conversorData.converteDataDoMYSQL(rs.getString("primeira_data")));
				data.setSegundaData(conversorData.converteDataDoMYSQL(rs.getString("segunda_data")));
				listaDatas.add(data);
			}
			for (DatasPojo paraData : listaDatas) {
				System.out.println(paraData.getNome());
				System.out.println(paraData.getPrimeiraData());
				System.out.println(paraData.getSegundaData());
				System.out.println("----------------------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void converteData() {
		Calendar c = Calendar.getInstance();

		c.set(1980, Calendar.FEBRUARY, 12);
		Date date = c.getTime();
		System.out.println(date);

		// Formatação de datas
		DateFormat f = DateFormat.getDateInstance();
		System.out.println("Data formatada: " + f.format(date));

		f = DateFormat.getDateInstance();
		System.out.println("Data formatada em horas: " + f.format(date));

		// Estilos
		f = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("Data formatada em FULL: " + f.format(date));

		f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println("Data formatada em MEDIUM: " + f.format(date));

		f = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println("Data formatada em SHORT: " + f.format(date));

		System.out.println("-----------------------------");
		// Converte uma String em data
		try {
			Date dataConvertidaString = f.parse("12/02/1980");
			DateFormat f1 = DateFormat.getDateInstance();
			System.out.println("Data convertida de String: " + f1.format(dataConvertidaString));

			// SimpleDateFormat

			SimpleDateFormat simpleDF = new SimpleDateFormat("dd/MM/yyyy");
			simpleDF.format(date);
			System.out.println("/* Convertendo usando o SimpleDateFormat */");

			System.out.println(date);
			System.out.println(simpleDF.parse("10/05/2015"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

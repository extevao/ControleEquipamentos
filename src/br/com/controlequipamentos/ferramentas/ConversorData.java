package br.com.controlequipamentos.ferramentas;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConversorData {

	public String converteDataDoMYSQL(String data) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dataConvertida = sdf.parse(data);
			SimpleDateFormat sdfDMY = new SimpleDateFormat("dd/MM/yyyy");
			return sdfDMY.format(dataConvertida);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro na convers�o da data: " + e);
			return "";
		}
	}

	public String converteDataParaMYSQL(String data) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataConvertida = sdf.parse(data);
			SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");
			return sdfYMD.format(dataConvertida);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro na convers�o da data: " + e);
			return "";
		}
	}

}

package pacoteTeste;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MudarPadraoDataMYSQL {
	public static void main(String[] args) throws ParseException {
		
		String dataParaMYSQL = converteDataParaMYSQL("08/07/2015");
		String dataDoMYSQL = converteDataDoMYSQL("2014-04-31");
		
		System.out.println("dataParaMYSQL " + dataParaMYSQL);
		System.out.println("dataDoMYSQL " + dataDoMYSQL);
	}

	public static void converterData(String dataString ){
		try {
//			Formata uma String em data
			DateFormat f = DateFormat.getDateInstance();
			Date dataFormatada = f.parse(dataString);
			System.out.println(f.format(dataFormatada));
			
//			SimpleDateFormat
			SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdfYMD.format(dataFormatada));
			
			SimpleDateFormat sdfDMY = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println(sdfDMY.format(dataFormatada));
			
		} catch (Exception e) {
			System.out.println("DEU MERDA !!!");
		}
	}
	
	public static String converteDataDoMYSQL(String data){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    Date dataConvertida = sdf.parse(data);
		    SimpleDateFormat sdfDMY = new SimpleDateFormat("dd/MM/yyyy");
			return sdfDMY.format(dataConvertida);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro na conversão da data: " + e);
			return "ERRO";
		}
		
		
	}
	public static String converteDataParaMYSQL(String data) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dataConvertida = sdf.parse(data);
			SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");
			return sdfYMD.format(dataConvertida);
		} catch (Exception e) {
			System.out.println("Ocorreu um erro na conversão da data: " + e);
			return "ERRO";
		}
		
	}
	
}

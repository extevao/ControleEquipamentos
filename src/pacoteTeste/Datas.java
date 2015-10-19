package pacoteTeste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Datas {

	public static void main(String[] args) throws Exception  {
	
		
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		data = sdf.parse("20/08/2001");
		
		System.out.println(sdf.format(data));
		
		
	}

}

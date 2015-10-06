package pacoteTeste;

import java.util.Calendar;
import java.util.Date;

public class Datas {

	public static void main(String[] args) {
	
		
		Date data = new Date();
		
		System.out.println(data);
		
		Calendar c = Calendar.getInstance();
		c.set(1980, Calendar.FEBRUARY, 12);
		System.out.println(c.getTime());
		System.out.println(c.get(Calendar.YEAR));
	}

}

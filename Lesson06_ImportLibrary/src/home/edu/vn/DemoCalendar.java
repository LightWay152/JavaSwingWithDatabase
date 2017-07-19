package home.edu.vn;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DemoCalendar {

	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
		int year=cal.get(Calendar.YEAR);
		System.out.println("This year is: "+year);
		int month=cal.get(Calendar.MONTH);
		System.out.println("This month is: "+(month+1));
		int day=cal.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today is: "+day);
		
		Date t=cal.getTime();
		//3/3/2017
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Today: "+sdf.format(t));
		
		SimpleDateFormat sdf2=new SimpleDateFormat("d/M/yyyy");
		System.out.println("Today: "+sdf2.format(t));
		
		SimpleDateFormat sdf3=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Today: "+sdf3.format(t));
		
		SimpleDateFormat sdf4=new SimpleDateFormat("hh:mm:ss aaa");
		System.out.println("Right now: "+sdf4.format(t));
	}

}

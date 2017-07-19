package home.edu.vn;

import java.text.DecimalFormat;

public class DemoDecimalFormat {

	public static void main(String[] args) {
		double math=5;
		double physic=6;
		double chemistry=9;
		double average=(math+physic+chemistry)/3;
		System.out.println("Average = "+average);
		
		DecimalFormat dcf=new DecimalFormat("#.##");
		System.out.println("Average = "+dcf.format(average));
	}

}

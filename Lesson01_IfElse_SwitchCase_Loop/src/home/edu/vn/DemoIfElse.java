package home.edu.vn;

import java.util.Scanner;

public class DemoIfElse {

	public static void main(String[] args) {
		//Check integer i is even number or odd number
		int i=0;
		System.out.println("Enter integer i:");
		i=new Scanner(System.in).nextInt();
		
		if(i%2==0)
			System.out.println(""+i+" is even number");
		else
			System.out.println(""+i+" is odd number");
		
		//Check year y is leap year or not
		int y=0;
		do
		{
			System.out.println("Enter year [y>=1990]:");
			y=new Scanner(System.in).nextInt();
		}
		while(y<=1990);
		
		if(y%4==0 && y%100!=0 || y%400==0)
			System.out.println(""+y+" is leap year");
		else
			System.out.println(""+y+" is not leap year");
	}

}

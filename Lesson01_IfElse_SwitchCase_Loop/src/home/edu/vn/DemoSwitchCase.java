package home.edu.vn;

import java.util.Scanner;

public class DemoSwitchCase {

	public static void main(String[] args) {
		int month;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter month:");
		month=sc.nextInt();
		switch(month)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Month "+month+" have 31 days");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Month"+month+" have 30 days");
			break;
		case 2:
			System.out.println("If the leap year there are 29 days, opposite 28 days");
			break;
		default:
			System.out.println("Incorrect input!");
			break;
		}
	}

}

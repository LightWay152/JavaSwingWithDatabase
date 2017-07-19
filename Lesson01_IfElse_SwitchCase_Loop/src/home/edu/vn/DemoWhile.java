package home.edu.vn;

import java.util.Scanner;

public class DemoWhile {

	public static void main(String[] args) {
		int n=1;
		int s=1;
		int i=1;
		System.out.println("Enter integer n:");
		n=new Scanner(System.in).nextInt();
		
		while(i<=n)
		{
			s*=i;
			i++;
		}
		System.out.println(""+n+"!="+s);
	}

}

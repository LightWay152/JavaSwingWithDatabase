package home.edu.vn;

import java.util.Scanner;

public class DemoDoWhile {

	public static void main(String[] args) {
		int n=1;
		int i=1;
		int s=1;
		System.out.println("Enter integer n:");
		n=new Scanner(System.in).nextInt();
		do
		{
			s*=i;
			i++;
		}
		while(i<=n);
		System.out.println(""+n+"!="+s);
	}

}

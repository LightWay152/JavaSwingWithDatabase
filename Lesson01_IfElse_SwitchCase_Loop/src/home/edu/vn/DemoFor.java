package home.edu.vn;

import java.util.Scanner;

public class DemoFor {

	public static void main(String[] args) {
		int n=1;
		int s=1;
		System.out.println("Enter integer n:");
		n=new Scanner(System.in).nextInt();
		
		for(int i=1;i<=n;i++)
		{
			s*=i;
		}
		System.out.println(""+n+"!="+s);
	}

}

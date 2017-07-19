package home.edu.vn;

import java.util.StringTokenizer;

public class DemoStringTokenizer {

	public static void main(String[] args) {
		String s="Learn, learn, learn more,..., learn forever";
		
		StringTokenizer token=new StringTokenizer(s);
		while(token.hasMoreTokens())
		{
			System.out.println(token.nextToken());
		}
		System.out.println("========================");
		StringTokenizer token2=new StringTokenizer(s,",");
		while(token2.hasMoreTokens())
		{
			System.out.println(token2.nextToken());
		}
		
		StringTokenizer token3=new StringTokenizer(s,", ");
		System.out.println("========================");
		while(token3.hasMoreTokens())
		{
			System.out.println(token3.nextToken());
		}
	}

}

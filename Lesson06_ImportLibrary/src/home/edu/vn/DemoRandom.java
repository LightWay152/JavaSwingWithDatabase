package home.edu.vn;

import java.util.Random;

public class DemoRandom {

	public static void main(String[] args) {
		int []A=new int[10];
		Random rd=new Random();
		for(int i=0;i<A.length;i++){
			A[i]=rd.nextInt(100);
		}
		System.out.println("Random array[0..100] is:");
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]+"\t");
		}
		
		int []A2=new int[10];
		Random rd2=new Random();
		for(int i=0;i<A2.length;i++){
			A2[i]=-50+rd2.nextInt(101);
		}
		System.out.println("\nRandom array[-50..50] is:");
		for(int i=0;i<A2.length;i++){
			System.out.print(A2[i]+"\t");
		}
	}

}

package home.edu.vn;

import java.util.Arrays;

public class DemoArray {

	public static void main(String[] args) {
		int A[]=new int[4];
		A[0]=7;
		A[1]=0;
		A[2]=3;
		A[3]=9;
		System.out.println("Your array is:");
		for(int i=0;i<A.length;i++)
		{
			System.out.print(A[i]+"\t");
		}
		
		Arrays.sort(A);
		System.out.println("\nSorted array is:");
		for(int i=0;i<A.length;i++)
		{
			System.out.print(A[i]+"\t");
		}
		
		System.out.println("\nPrime numbers are:");
		for(int i=0;i<A.length;i++)
		{
			int count=0;
			for(int j=1;j<=A[i];j++)
			{
				if(A[i]%j==0)
				{
					count++;
				}
			}
			if(count==2)
				System.out.print(A[i]+"\t");
		}
	}

}

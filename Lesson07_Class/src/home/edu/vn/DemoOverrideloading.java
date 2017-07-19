package home.edu.vn;

public class DemoOverrideloading {

	public static int fn(int x,int y)
	{
		return x+y;
	}
	public static double fn(double x,double y)
	{
		return x+y+100;
	}
	public static double fn2(double x,double y,double z)
	{
		return x+y+z;
	}
	public static int fn2(int x)
	{
		return x;
	}
	//ctrl+shift+/
/*	public static int fn3(int x,int y)
	{
		
	}
	public static double fn3(int x,int y)
	{
		
	}*/
	//parameter list (one way array flexibility)
	public static int fn4(int ...arr)
	{
		int sum=0;
		for(int x: arr)
			sum+=x;
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(fn(1,1));
		System.out.println(fn(1.0,1.0));
		System.out.println(fn2(1,2,3));
		System.out.println(fn2(1));
		
		System.out.println(fn4(1,2,3));
		System.out.println(fn4(1,2,3,4));
	}

}

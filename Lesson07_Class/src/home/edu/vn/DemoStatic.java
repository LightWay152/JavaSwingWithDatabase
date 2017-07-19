package home.edu.vn;

public class DemoStatic {
	public int y;
	public static int x=5;//x is class member
	
	
	public static void fn()
	{
		//never use because variable of static was born 
		//before all of variable non-static
		//System.out.println(y);//never use
		System.out.println(x);
	}
	
	public void fn2()
	{
		System.out.println(y);
		System.out.println(x);
	}
}

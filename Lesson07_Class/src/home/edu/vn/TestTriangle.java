package home.edu.vn;

public class DemoTestTriangle {

	public static void main(String[] args) {
		DemoTriangle tg1=new DemoTriangle(4,5,6);
		System.out.println(tg1);
		
		DemoTriangle tg2=new DemoTriangle(1,2,3);
		System.out.println(tg2);
		
		System.out.println("Area of Triangle 1 = "+tg1.area());
		System.out.println("Area of Triangle 2 = "+tg2.area());
		
	}
	
}

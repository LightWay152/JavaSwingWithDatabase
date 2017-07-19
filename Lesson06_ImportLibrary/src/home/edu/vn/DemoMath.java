package home.edu.vn;

public class DemoMath {

	public static void main(String[] args) {
		int n=25;
		System.out.println("The square root of 25 = "+Math.sqrt(n));
		int x=8;
		int y=3;
		System.out.println(x+"^"+y+"="+Math.pow(x,y));
		
		int k=-113;
		System.out.println("The absolute value of k = "+Math.abs(k));
		
		int radius=5;
		double perimeter=2*Math.PI*radius;
		double area=Math.PI*Math.pow(radius, 2);
		System.out.println("Perimeter = "+perimeter);
		System.out.println("Area = "+area);
		
		int degrees=55;
		double radian=Math.PI*degrees/180;
		System.out.println("sin("+degrees+")="+Math.sin(radian));
		System.out.println("cos("+degrees+")="+Math.cos(radian));
		System.out.println("tan("+degrees+")="+Math.tan(radian));
		System.out.println("cotan("+degrees+")="+Math.cos(radian)/Math.sin(radian));
		System.out.println("cotan("+degrees+")="+1/Math.tan(radian));
	}

}

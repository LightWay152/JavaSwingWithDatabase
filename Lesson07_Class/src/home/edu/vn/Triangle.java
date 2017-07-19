package home.edu.vn;

public class DemoTriangle {
	private int a_edge;
	private int b_edge;
	private int c_edge;
	public int getA_edge() {
		return a_edge;
	}
	public void setA_edge(int a_edge) {
		this.a_edge = a_edge;
	}
	public int getB_edge() {
		return b_edge;
	}
	public void setB_edge(int b_edge) {
		this.b_edge = b_edge;
	}
	public int getC_edge() {
		return c_edge;
	}
	public void setC_edge(int c_edge) {
		this.c_edge = c_edge;
	}
	public DemoTriangle(int a_edge, int b_edge, int c_edge) {
		super();
		this.a_edge = a_edge;
		this.b_edge = b_edge;
		this.c_edge = c_edge;
	}
	public DemoTriangle() {
		super();
	}
	public String toString() {
		
		
		String s="Triangle [a_edge=" + a_edge + ", b_edge=" + b_edge
				+ ", c_edge=" + c_edge + "]";
		
		if(checkValid()==false)
		{
			return s+"==>Triangle incorrect";
		}
		else{
			return s+"\nPerimeter = "+perimeter()+"\nArea = "+area();
		}
		
	}
	private boolean checkValid()
	{
		boolean check=this.a_edge>0 && this.b_edge>0 && this.c_edge>0 &&
				(this.a_edge+this.b_edge)>this.c_edge &&
				(this.a_edge+this.c_edge)>this.b_edge &&
				(this.b_edge+this.c_edge)>this.a_edge;
		return check;
	}
	public double perimeter()
	{
		return this.a_edge+this.b_edge+this.c_edge;
	}
	public double area()
	{
		double p=perimeter()/2;//half of perimeter
		double a=Math.sqrt(p*(p-this.a_edge)*(p-this.b_edge)*(p-this.c_edge));
		return a;//a = area
	}
}

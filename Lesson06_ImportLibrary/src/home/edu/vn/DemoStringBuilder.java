package home.edu.vn;

public class DemoStringBuilder {

	public static void main(String[] args) {
		StringBuilder builder=new StringBuilder();
		
		for(int i=0;i<100;i++){
			builder.append("Element at pos[i] = "+i);
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}

}

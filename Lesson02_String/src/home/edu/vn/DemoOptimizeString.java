package home.edu.vn;

public class DemoOptimizeString {

	public static void main(String[] args) {
		String s = "   Nguyen     Van   Teo   ";
		System.out.println(s);
		//s="Nguyen Van Teo";
		s=s.trim();
		String []arr=s.split(" ");
		String sOptimize="";
		for(String from : arr)
		{
			if(from.trim().length()!=0)
				sOptimize += from +" ";
		}
		sOptimize=sOptimize.trim();
		System.out.println(sOptimize);
	}

}

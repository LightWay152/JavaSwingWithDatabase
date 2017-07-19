package home.edu.vn;

public class RunTimeHandling {

	public static void main(String[] args) {
		
		try
		{
			int x=1/0;//Unchecked Error
			
			System.out.println("This is Runtime Error (Detail is divided by 0");
		}
		catch(Exception ex)
		{
			//Print detail error to check error
			ex.printStackTrace();
		}
		
		System.out.println("Good bye!");
	}

}

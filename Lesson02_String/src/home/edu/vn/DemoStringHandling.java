package home.edu.vn;

public class DemoStringHandling {

	public static void main(String[] args) {
		String s = "5 Topica Education 3";
		System.out.println("Length of string = "+s.length());
		
		//Count string have how many UpperCase, LowerCase, Number:
		char []arr = s.toCharArray();
		int qtyUpperCase = 0;
		int qtyLowerCase = 0;
		int qtyNumber = 0;
		for(int i=0; i<arr.length; i++)
		{
			char c = arr[i];
			if(Character.isUpperCase(c))
			{
				qtyUpperCase++;
			}
			if(Character.isLowerCase(c))
			{
				qtyLowerCase++;
			}
			if(Character.isDigit(c))
			{
				qtyNumber++;
			}
		}
		System.out.println("String have " + qtyUpperCase + " upper cases");
		System.out.println("String have " + qtyLowerCase + " lower cases");
		System.out.println("String have " + qtyNumber + " numbers");
		
		String song1 = "d:/Music/TrinhMusic/riengmotgoctroi.mp3";
		//String song2 = "d:\\Music\\TrinhMusic\\riengmotgoctroi.mp3";
		int lastPos = song1.lastIndexOf("/");
		String nameOfSong = song1.substring(lastPos+1);
		System.out.println("Name of song 1 = "+nameOfSong);
		
		int lastPointPos = song1.lastIndexOf(".");
		nameOfSong = song1.substring(lastPos+1, lastPointPos);
		System.out.println("Name of song 1 not have .mp3 = "+nameOfSong);
		
		
		
		
		
	}
}

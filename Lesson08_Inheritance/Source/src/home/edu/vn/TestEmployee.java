package home.edu.vn;

public class TestEmployee {

	public static void main(String[] args) {
		Employee teo=new OfficialEmployee();
		teo.setName("Nguyễn Văn Tèo");
		System.out.println(teo);
		
		OfficialEmployee ty=new OfficialEmployee();
		ty.setName("Trần Thị Tý");
		System.out.println(ty);
		
		teo=new PartTimeEmployee();
		teo.setName("Nguyễn Văn Tèo");
		System.out.println(teo);
	}

}

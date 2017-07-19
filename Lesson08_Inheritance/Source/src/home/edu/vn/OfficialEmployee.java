package home.edu.vn;

public class OfficialEmployee extends Employee{

	public int exportSalary() {
		return 5000;
	}

	public String toString() {
		return super.toString()+"==> vì là nhân viên chính thức";
	}
	
}

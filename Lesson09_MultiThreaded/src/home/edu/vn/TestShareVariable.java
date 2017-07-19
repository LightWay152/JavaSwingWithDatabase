package home.edu.vn;

public class TestShareVariable {

	public static void main(String[] args) {
		MyThread2 mt=new MyThread2();
		
		Thread th1=new Thread(mt);
		th1.setName("[TT 1]");
		th1.start();
		
		Thread th2=new Thread(mt);
		th2.setName("[TT 2]");
		th2.start();
		
		Thread th3=new Thread(mt);
		th3.setName("[TT 3]");
		th3.start();
		
		System.out.println("current x = "+mt.getX());
		
	}

}

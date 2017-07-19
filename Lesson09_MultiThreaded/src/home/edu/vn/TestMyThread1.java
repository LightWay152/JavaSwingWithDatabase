package home.edu.vn;

public class TestMyThread1 {

	public static void main(String[] args) {
		MyThread1 th1=new MyThread1();
		th1.setName("Thread 1");
		th1.start();//start thread
		
		MyThread1 th2= new MyThread1();
		th2.setName("Thread 2");
		th2.start();
	}

}

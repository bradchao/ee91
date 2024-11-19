package tw.brad.tutor;

public class Brad67 {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
		}
		
		System.out.println("Main finish");
		
		
	}
}
class Thread1 extends Thread {
	@Override
	public void run() {
		System.out.println("T1 start working...");
		try {
			Thread.sleep(3*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("T1 finish");
	}
}
class Thread2 extends Thread {
	@Override
	public void run() {
		System.out.println("T2 start working...");
		try {
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("T2 finish");
	}
}
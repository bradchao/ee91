package tw.brad.tutor;

public class Brad62 {
	public static void main(String[] args) {
		Brad621 obj1 = new Brad621("A");
		Brad621 obj2 = new Brad621("B");
		Brad622 obj3 = new Brad622("C");
		Thread t3 = new Thread(obj3);
		obj1.run();
		obj1.run();
		System.out.println("Main");
		obj1.start();
		obj2.start();
		t3.start();
		System.out.println("finish");
		//obj1.start();
	}
}

class Brad621 extends Thread {
	private String name;
	Brad621(String name){this.name = name;}
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

class Brad622 implements Runnable{
	private String name;
	Brad622(String name){this.name = name;}
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.printf("%s : %d\n", name, i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}


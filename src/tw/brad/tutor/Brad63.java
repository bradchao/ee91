package tw.brad.tutor;

public class Brad63 {

	public static void main(String[] args) {
		Brad631 obj = new Brad631();
		obj.setDaemon(true);
		obj.start();
		System.out.println("main");
	}

}
class Brad631 extends Thread {
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}

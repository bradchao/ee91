package tw.brad.tutor;

import java.util.Timer;
import java.util.TimerTask;

public class Brad64 {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new Brad641(), 3*1000, 1*1000);
		timer.schedule(new Stop(timer), 10*1000);
		System.out.println("Main");
	}
}
class Brad641 extends TimerTask {
	private int i;
	@Override
	public void run() {
		System.out.println(i++);
	}
}
class Stop extends TimerTask {
	private Timer timer;
	Stop(Timer timer){this.timer = timer;}
	@Override
	public void run() {
		timer.purge();
		timer.cancel();
		timer = null;
	}
}
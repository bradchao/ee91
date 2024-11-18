package tw.brad.apis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel {
	private Timer timer;
	
	public MyClock() {
		
		timer = new Timer();
		timer.schedule(new MyTask(), 0, 100);
	}
	
	private class MyTask extends TimerTask {
		@Override
		public void run() {
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			setText(sdf.format(now));	
		}
	} 
	
	
}

package tw.brad.apis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

public class GamePanelV2 extends JPanel{
	private Timer timer;
	private BufferedImage[] ballImgs;
	private int viewW, viewH;
	private LinkedList<BallTask> balls;
	
	public GamePanelV2() throws Exception{
		setBackground(Color.YELLOW);
		timer = new Timer();
		timer.schedule(new RefreshTask(), 0, 16);
		ballImgs = new BufferedImage[]{
				ImageIO.read(new File("dir2/ball0.png")),
				ImageIO.read(new File("dir2/ball1.png")),
				ImageIO.read(new File("dir2/ball2.png")),
				ImageIO.read(new File("dir2/ball3.png")),
				};
		
		balls = new LinkedList<BallTask>();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BallTask ball = new BallTask(e.getX(), e.getY());
				balls.add(ball);
				timer.schedule(ball, 500, 30);
			}
		});
		
	}
	
	private class RefreshTask extends TimerTask{
		@Override
		public void run() {
			repaint();
		}
	}
	
	private class BallTask extends TimerTask {
		private int x, y, dx, dy;
		private BufferedImage img;
		private int w, h;
		
		public BallTask(int x, int y) {
			dx = (int)(Math.random()*19)-8;
			dy = (int)(Math.random()*19)-8;
			img = ballImgs[(int)(Math.random()*ballImgs.length)];
			w = img.getWidth();
			h = img.getHeight();
			this.x = x - (int)(w/2.0); 
			this.y = y - (int)(h/2.0);
		}
		
		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public BufferedImage getImg() {
			return img;
		}

		@Override
		public void run() {
			x += dx;
			y += dy;
			if (x < 0 || x + w > viewW) {
				dx *= -1;
			}
			if (y < 0 || y + h > viewH) {
				dy *= -1;
			}
			
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		viewW = getWidth(); viewH = getHeight();
		
		for (BallTask ball :balls) {
			g.drawImage(ball.getImg(), ball.getX(), ball.getY(), null);
		}
		
				
	}
	
}

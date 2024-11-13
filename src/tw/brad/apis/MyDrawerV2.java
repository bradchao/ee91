package tw.brad.apis;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.DebugGraphics;
import javax.swing.JPanel;

public class MyDrawerV2 extends JPanel{
	private LinkedList<Line> lines, recycle;
	private Color nowColor;
	
	public MyDrawerV2() {
		setBackground(Color.YELLOW);
		MyListener listener = new MyListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		lines = new LinkedList<>();
		recycle = new LinkedList<>();
		nowColor = Color.BLUE;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(nowColor);
		g2d.setStroke(new BasicStroke(4));
		
		for(Line line : lines) {
			
			for (int i= 1; i<line.getSize(); i++) {
				Point p0 = line.getPoint(i-1);
				Point p1 = line.getPoint(i);
				g2d.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			}
			
		}
		
	}
	
	private class MyListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			recycle.clear();
			Line line = new Line(nowColor, 4);
			Point point = new Point(e.getX(), e.getY());
			
			line.addPoint(point);
			
			lines.add(line);
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			Point point = new Point(e.getX(), e.getY());
			lines.getLast().addPoint(point);

			repaint();
		}
		
	}	
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size()>0) {
			recycle.add(lines.removeLast());
			repaint();
		}
	}
	public void redo() {
		if (recycle.size()>0) {
			lines.add(recycle.removeLast());
			repaint();
		}
		
	}
	public void changeColor(Color newColor) {
		nowColor = newColor;
	}
}







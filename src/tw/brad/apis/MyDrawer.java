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

public class MyDrawer extends JPanel{
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines, recycle;
	
	public MyDrawer() {
		setBackground(Color.YELLOW);
		MyListener listener = new MyListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		lines = new LinkedList<>();
		recycle = new LinkedList<>();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLUE);
		g2d.setStroke(new BasicStroke(4));
		
		for(LinkedList<HashMap<String, Integer>> line : lines) {
			for (int i= 1; i<line.size(); i++) {
				HashMap<String, Integer> p0 = line.get(i-1);
				HashMap<String, Integer> p1 = line.get(i);
				g2d.drawLine(p0.get("x"), p0.get("y"), p1.get("x"), p1.get("y"));
			}
			
		}
		
	}
	
	private class MyListener extends MouseAdapter{
		@Override
		public void mousePressed(MouseEvent e) {
			recycle.clear();
			LinkedList<HashMap<String, Integer>> line = new LinkedList<HashMap<String,Integer>>();
			
			HashMap<String, Integer> point = new HashMap<String, Integer>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			
			line.add(point);
			
			lines.add(line);
			
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			HashMap<String, Integer> point = new HashMap<String, Integer>();
			point.put("x", e.getX());
			point.put("y", e.getY());
			
			lines.getLast().add(point);
			//lines.get(lines.size()-1).add(point);

			repaint();
		}
		
	}	
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() {
		if (lines.size()>0) {
			LinkedList<HashMap<String, Integer>> line = lines.removeLast(); 
			recycle.add(line);
			repaint();
		}
	}
	public void redo() {
		if (recycle.size()>0) {
			lines.add(recycle.removeLast());
			repaint();
		}
		
	}
	
}







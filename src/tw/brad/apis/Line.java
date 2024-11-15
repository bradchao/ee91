package tw.brad.apis;

import java.awt.Color;
import java.io.Serializable;
import java.util.LinkedList;

public class Line implements Serializable {
	private LinkedList<Point> line;
	private Color color;
	private float width;
	
	public Line(Color color, float width) {
		this.color = color; this.width = width;
		line = new LinkedList<Point>();
	}

	public Color getColor() {
		return color;
	}

	public float getWidth() {
		return width;
	}
	
	public void addPoint(Point point) {
		line.add(point);
	}
	
	public Point getPoint(int index) {
		return line.get(index);
	}
	
	public int getSize() {
		return line.size();
	}
}

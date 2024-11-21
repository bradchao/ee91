package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.apis.FoodTable;

public class MyFood extends JFrame{
	private FoodTable foodTable;
	
	public MyFood() {
		
		setLayout(new BorderLayout());
		foodTable = new FoodTable();
		add(foodTable, BorderLayout.CENTER);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new MyFood();
	}

}

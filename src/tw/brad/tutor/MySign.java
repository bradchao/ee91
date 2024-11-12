package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.apis.MyDrawer;

public class MySign extends JFrame{
	private MyDrawer myDrawer;
	
	public MySign() {
		super("簽名");
		
		setLayout(new BorderLayout());
		myDrawer = new MyDrawer();
		add(myDrawer, BorderLayout.CENTER);
		
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}

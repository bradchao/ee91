package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.apis.GamePanel;

public class MyGame extends JFrame{
	private GamePanel myPanel;

	public MyGame() {
		setLayout(new BorderLayout());
		
		myPanel = new GamePanel();
		add(myPanel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new MyGame();
	}

}

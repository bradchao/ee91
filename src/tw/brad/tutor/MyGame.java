package tw.brad.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.brad.apis.GamePanelV2;

public class MyGame extends JFrame{
	private GamePanelV2 myPanel;

	public MyGame() throws Exception{
		setLayout(new BorderLayout());
		
		myPanel = new GamePanelV2();
		add(myPanel, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		try {
			new MyGame();
		}catch (Exception e) {
			System.out.println("XXXX");
		}
	
	}

}

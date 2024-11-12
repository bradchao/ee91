package tw.brad.tutor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Brad28 extends JFrame{
	private JButton b1, b2, b3;
	private int counter;
	
	public Brad28() {
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
		
		setLayout(new FlowLayout());
		add(b1); add(b2); add(b3);
		
		setVisible(true);
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	private void initEvent() {
		MyListener2 listener = new MyListener2(this);
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);
	}
	
	public JButton getB1() {return b1;}
	public JButton getB2() {return b2;}
	public JButton getB3() {return b3;}
	public void addCounter(int n) {counter += n;}
	
	public static void main(String[] args) {
		new Brad28();
	}

}
class MyListener2 implements ActionListener {
	private Brad28 brad28;
	public MyListener2(Brad28 brad28) {
		this.brad28 = brad28;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e.getActionCommand());
		if (e.getSource() == brad28.getB1()) {
			System.out.println("B1");
			brad28.addCounter(1);
		}else if (e.getSource() == brad28.getB2()) {
			System.out.println("B2");
			brad28.addCounter(2);
		}else if (e.getSource() == brad28.getB3()) {
			System.out.println("B3");
			brad28.addCounter(3);
		}
	}
	
}





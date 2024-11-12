package tw.brad.tutor;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Brad28 extends JFrame  implements ActionListener{
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
		
		this.initEvent();
	}
	
	private void initEvent() {
		MyListener2 listener = new MyListener2(this);
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		b3.addActionListener(listener);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				counter++;
				System.out.println("3");
			}
		});
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				counter += 2;
			}
		});
		
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				counter += 3;
			}
		});
		
	}
	
	public JButton getB1() {return b1;}
	public JButton getB2() {return b2;}
	public JButton getB3() {return b3;}
	public void addCounter(int n) {counter += n;}
	
	public static void main(String[] args) {
		new Brad28();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			System.out.println("B1");
			counter++;
			System.out.println("2");
		}else if (e.getSource() == b2) {
			System.out.println("B2");
			counter += 2;
		}else if (e.getSource() == b3) {
			System.out.println("B3");
			counter += 3;
		}		
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
			System.out.println("1");
		}else if (e.getSource() == brad28.getB2()) {
			System.out.println("B2");
			brad28.addCounter(2);
		}else if (e.getSource() == brad28.getB3()) {
			System.out.println("B3");
			brad28.addCounter(3);
		}
	}
	
}





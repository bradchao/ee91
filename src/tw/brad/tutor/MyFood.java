package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import tw.brad.apis.FoodTable;

public class MyFood extends JFrame{
	private FoodTable foodTable;
	private JButton del;
	
	public MyFood() {
		
		setLayout(new BorderLayout());
		foodTable = new FoodTable();
		JScrollPane jsp = new JScrollPane(foodTable);
		add(jsp, BorderLayout.CENTER);
		
		JPanel top = new JPanel(new FlowLayout());
		del = new JButton("Delete");
		top.add(del);
		add(top, BorderLayout.NORTH);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	private void initEvent() {
		del.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				foodTable.delRow();
			}
		});
	}
	
	public static void main(String[] args) {
		new MyFood();
	}

}

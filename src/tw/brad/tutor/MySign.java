package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.brad.apis.MyDrawerV2;

public class MySign extends JFrame{
	private MyDrawerV2 myDrawer;
	private JButton clear, undo, redo, color, saveJpeg;
	
	public MySign() {
		super("簽名");
		
		setLayout(new BorderLayout());
		myDrawer = new MyDrawerV2();
		add(myDrawer, BorderLayout.CENTER);
		
		clear = new JButton("清除");
		undo = new JButton("上一步");
		redo = new JButton("下一步");
		color = new JButton("改色");
		saveJpeg = new JButton("存檔");
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear);top.add(undo);top.add(redo);top.add(color);
		top.add(saveJpeg);
		
		add(top, BorderLayout.NORTH);
		
		setSize(800, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
	}
	
	private void initEvent() {
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();
			}
		});
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();
			}
		});
		color.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		saveJpeg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.saveJPEG();
			}
		});
	}
	
	private void changeColor() {
		Color newColor = JColorChooser.showDialog(this, "改顏色", myDrawer.getColor());
		if (newColor != null) {
			myDrawer.setColor(newColor);
		}
	}
	
	public static void main(String[] args) {
		new MySign();
	}

}

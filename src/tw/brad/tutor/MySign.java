package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tw.brad.apis.MyClock;
import tw.brad.apis.MyDrawerV2;

public class MySign extends JFrame{
	private MyDrawerV2 myDrawer;
	private JButton clear, undo, redo, color, 
			saveJpeg, saveObj, loadObj;
	private MyClock myClock;
	
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
		saveObj = new JButton("序列");
		loadObj = new JButton("解序");
		
		myClock = new MyClock();
				
		
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear);top.add(undo);top.add(redo);top.add(color);
		top.add(saveJpeg); top.add(saveObj); top.add(loadObj);
		
		top.add(myClock);
		
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
				saveJpeg();
			}
		});
		
		saveObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveObject();
			}
		});
		loadObj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadObject();
			}
		});
	}
	
	private void changeColor() {
		Color newColor = JColorChooser.showDialog(this, "改顏色", myDrawer.getColor());
		if (newColor != null) {
			myDrawer.setColor(newColor);
		}
	}
	
	private void saveJpeg() {
		JFileChooser jfc = new JFileChooser();
		if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
			File saveFile = jfc.getSelectedFile();
			try {
				myDrawer.saveJPEG(saveFile);
				JOptionPane.showMessageDialog(this, "Save Success");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Save Failure");
			}
		}
		
	}
	
	private void saveObject() {
		try {
			myDrawer.saveLines(new File("dir1/lines.ok"));
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void loadObject() {
		try {
			myDrawer.loadLines(new File("dir1/lines.ok"));
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void main(String[] args) {
		new MySign();
	}

}

package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener{
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String answer;
	
	public GuessNumber() {
		super("猜數字遊戲");
		
		setLayout(new BorderLayout());
		guess = new JButton("猜");
		input = new JTextField();
		log = new JTextArea();
		
		JPanel top = new JPanel(new BorderLayout());
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		
		add(top, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		guess.addActionListener(this);
		
		initGame();
	}
	
	private void initGame() {
		answer = createAnswer();
	}
	
	private String createAnswer() {
        final int nums = 10;
        int[] poker = new int[nums];
        for (int i=0; i<poker.length; i++) poker[i] = i;

        for (int i=nums-1; i>0; i--){
            int rand = (int)(Math.random()*(i+1));
            // poker[rand] <=> poker[i]
            int temp = poker[rand];
            poker[rand] = poker[i];
            poker[i] = temp;
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<3; i++) sb.append(poker[i]);
        
		return sb.toString();
	}
	
	private String checkAB(String g) {
		return "1A2B";
	}
	
	public static void main(String[] args) {
		new GuessNumber();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String strInput = input.getText();
		String result = checkAB(strInput);
		log.append(String.format("%s => %s\n", strInput, result));
		input.setText("");
	}
}


//--------------------------------
class MyListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK");
	}
	
}


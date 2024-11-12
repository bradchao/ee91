package tw.brad.tutor;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GuessNumber extends JFrame implements ActionListener{
	private JButton guess;
	private JTextField input;
	private JTextArea log;
	private String answer;
	private int counter;
	private int d;
	
	public GuessNumber() {
		super("猜數字遊戲");
		
		setLayout(new BorderLayout(4,4));
		guess = new JButton("猜");
		input = new JTextField();
		log = new JTextArea();
		
		input.setFont(new Font(null, Font.BOLD | Font.ITALIC, 24));
		log.setFont(new Font(null, Font.BOLD, 24));
		
		JPanel top = new JPanel(new BorderLayout(4, 4));
		top.add(guess, BorderLayout.EAST);
		top.add(input, BorderLayout.CENTER);
		
		add(top, BorderLayout.NORTH);
		add(log, BorderLayout.CENTER);
		
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		guess.addActionListener(this);
		//guess.addActionListener(new MyListener());
		
		initGame();
	}
	
	private void initGame() {
		d = 4;
		answer = createAnswer();
		counter = 0;
		log.setText("");
		//System.out.println(answer);
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
        for(int i=0; i<d; i++) sb.append(poker[i]);
        
		return sb.toString();
	}
	
	private String checkAB(String g) {
		int A = 0, B = 0;
		for (int i=0; i<answer.length(); i++) {
			if (answer.charAt(i) == g.charAt(i)) {
				A++;
			}else if (answer.indexOf(g.charAt(i)) != -1) {
				B++;
			}
		}
		
		return String.format("%dA%dB",A, B);
	}
	
	public static void main(String[] args) {
		new GuessNumber();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		counter++;
		String strInput = input.getText();
		String result = checkAB(strInput);
		log.append(String.format("%d. %s => %s\n", counter, strInput, result));
		input.setText("");
		
		if (result.equals(String.format("%dA0B", d))) {
			JOptionPane.showMessageDialog(this, "恭喜老爺,賀喜夫人");
			initGame();
		}else if (counter == 10) {
			JOptionPane.showMessageDialog(this, "魯蛇, 答案是:" + answer);
			initGame();
		}
		
	}
}


//--------------------------------
class MyListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("OK");
	}
	
}


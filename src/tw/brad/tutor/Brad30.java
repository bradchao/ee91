package tw.brad.tutor;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Brad30 {

	public static void main(String[] args) {
		TreeSet<Integer> lottery = new TreeSet<Integer>();
		
		while (lottery.size()<6) {
			//lottery.add(new Random().nextInt(49) + 1);
			lottery.add((int)(Math.random()*49+1));
		}
		System.out.println(lottery);
		System.out.println("----");
		for (Integer num :lottery ) {
			System.out.println(num);
		}
		
		
	}

}

package tw.brad.tutor;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Brad30 {

	public static void main(String[] args) {
		TreeSet<Integer> lottery = new TreeSet<>();
		while (lottery.size()<6) {
			lottery.add(new Random().nextInt(49) + 1);
		}
		System.out.println(lottery);
	}

}

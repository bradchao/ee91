package tw.brad.tutor;

import java.util.concurrent.TimeoutException;

import javax.xml.crypto.KeySelectorException;

import tw.brad.apis.TWId;

public class Brad35 {
	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setLeg(2);
		} catch (Exception e) {
			System.out.println("Error");
		}
		System.out.println(b1.getLeg());
		System.out.println("----");
		
		try {
			TWId myId = new TWId("A123456787");
			System.out.println(myId);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			b1.m1(2);
		} catch (TimeoutException e) {
		} catch (Exception e) {
		}
		
		
	}
}
class Bird {
	private int leg;
	int getLeg() {
		return leg;
	}
	public void setLeg(int leg) throws Exception {
		if (leg >= 0 && leg <= 2) {
			this.leg = leg;
		}else {
			throw new Exception();
		}
	}
	
	void m1(int a) throws Exception{
		if (a>0) {
			System.out.println(a);
		}else if (a == 0) {
			throw new RuntimeException();
		}
	}
	
}

package tw.brad.tutor;

import java.util.HashSet;
import java.util.Iterator;

import tw.brad.apis.Bike;

public class Brad29 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("Brad");
		set.add(123);	// int => Auto-boxing => Integer 
		set.add(12.3);
		set.add(true);
		set.add(123);
		set.add("Brad");
		set.add(new Bike());
		System.out.println(set.size());
		System.out.println("----");
		System.out.println(set);
		System.out.println("----");
		
		Iterator it = set.iterator();
		
		while (it.hasNext()) {
			System.out.println(it.next()); 
		}
	}

}

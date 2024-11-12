package tw.brad.tutor;

import java.util.LinkedList;

public class Brad31 {

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<String>();
		names.add(0,"Eric");
		names.add(0,"Andy");
		names.add(0,"Brad");
		names.add(0,"Tony");
		names.add(0,"Mark");
		names.add(0,"John");
		
		System.out.println(names.size());
		for (String name:names) {
			System.out.println(name);
		}
		System.out.println("---");
		System.out.println(names.get(2));
		System.out.println("---");
		names.remove(2);
		System.out.println(names.get(2));
		
		
	}

}

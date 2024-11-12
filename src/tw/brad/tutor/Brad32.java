package tw.brad.tutor;

import java.util.HashMap;
import java.util.Set;

public class Brad32 {

	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap<String, Object>();
		person.put("name", "Brad");
		person.put("age", 18);
		person.put("weight", 78.3);
		person.put("gener", true);
		
		System.out.println(person.get("name"));
		System.out.println("----");
		Set<String> keys = person.keySet();
		for(String key : keys) {
			System.out.printf("%s : %s\n", key, person.get(key));
		}
		
	}

}

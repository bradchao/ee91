package tw.brad.tutor;

public class Brad23 {
	public static void main(String[] args) {
		System.out.println(Brad231.counter);
		Brad231 obj1 = new Brad231();
		Brad231 obj2 = new Brad231();
		Brad231 obj3 = new Brad231();
		System.out.println(Brad231.counter);
		System.out.println(obj1.i);
		System.out.println(obj2.i);
		System.out.println(obj3.i);
	}
}
class Brad231 {
	static int counter;
	int i;
	Brad231(){
		counter++;
		i++;
	}
}

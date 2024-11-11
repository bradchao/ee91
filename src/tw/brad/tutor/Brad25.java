package tw.brad.tutor;

public class Brad25 {
	public static void main(String[] args) {
		Brad251 obj1 = new Brad251() {
			@Override
			void m3() {
				System.out.println("Brad251:m3()");
			}
		};
		Brad251 obj2 = new Brad252();
		Brad251 obj3 = new Brad253();
		
		obj1.m3();
		obj2.m3();
		obj3.m3();
		
	}
}
abstract class Brad251 {
	void m1() {}
	void m2() {}
	abstract void m3();
}
class Brad252 extends Brad251 {
	void m3() {System.out.println("Brad252:m3()");}
}
class Brad253 extends Brad251 {
	void m3() {System.out.println("Brad253:m3()");}
}

abstract class Brad254 {
	
}


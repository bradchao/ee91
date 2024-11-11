package tw.brad.tutor;

public class Brad24 {
	public static void main(String[] args) {
		System.out.println("Brad1");
		System.out.println("Brad2");
		System.out.println("Brad3");
		Brad241.m2();
		System.out.println("Brad4");
		Brad241.m2();
	}
}
class Brad241 {
	{
		System.out.println("Brad241{}");
	}
	static {
		System.out.println("Brad241{static}");
	}
	Brad241(){
		System.out.println("Brad241()");
	}
	void m1() {
		System.out.println("Brad241:m1()");
	}
	static void m2() {
		System.out.println("Brad241:m2()");
	}
}
class Brad242 extends Brad241{
	static {
		System.out.println("Brad242{static}");
	}	
	Brad242(){
		// super();
		System.out.println("Brad242()");
	}
	static void m3() {
		System.out.println("Brad242:m3()");
	}
}

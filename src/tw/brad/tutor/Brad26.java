package tw.brad.tutor;

public class Brad26 {
	public static void main(String[] args) {
		Brad261 obj1 = new Brad263();
		Brad262 obj2 = new Brad263();
		obj1.m1();
		Brad263 obj4 = (Brad263)obj1;
		obj4.m3();
		
		if (obj1 instanceof Brad268) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		
		
		obj2.m3();
		Brad263 obj3 = new Brad263();
		obj3.m1();
		Brad261 obj5 = new Brad267();
		obj1.m1();
		obj5.m1();
	}
}
interface Brad261 {
	void m1();
	void m2();
}
interface Brad262 {
	int m3();
	void m4();
}
class Brad263 extends Object implements Brad261, Brad262 {
	public void m1() {System.out.println("Brad263:m1()");}
	public void m2() {}
	public int m3() {return 1;};
	public void m4() {};
}

interface Brad264 extends Brad261, Brad262 {
	void m5();
}
class Brad265 implements Brad264 {

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m5() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int m3() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		
	}
	
}
class Brad266 {
	void m1() {}
	void m2() {}
}
class Brad267 extends Object implements Brad261, Brad262 {
	public void m1() {System.out.println("Brad267:m1()");}
	public void m2() {}
	public int m3() {return 1;};
	public void m4() {};
}
class Brad268 extends Brad263{}





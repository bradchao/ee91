package tw.brad.tutor;

public class Brad27 {
	public static void main(String[] args) {
		Brad271 obj1 = new Brad271(1);
	}
}
class Brad271 extends Object{
	Brad271(int a){
		System.out.println("Brad271");
	}
}
class Brad272 extends Brad271{
	Brad272(){
		// super();
		super(2);
	}
}
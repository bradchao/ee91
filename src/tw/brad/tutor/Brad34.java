package tw.brad.tutor;

public class Brad34 {

	public static void main(String[] args) {
		int a = 0, b = 0;
		System.out.println("Brad");
		int[] d = {1,2,3,4};
		
		try {
			System.out.println(d[1000]);
			int c = a / b;
			System.out.println(c);
		}catch(RuntimeException re) {
			System.out.println("Ooop!");
		}
		
		System.out.println("Finish");
	}

}

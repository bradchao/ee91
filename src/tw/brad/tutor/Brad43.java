package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad43 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try (FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
				FileOutputStream fout = new FileOutputStream("dir2/brad.jpg");){
			int b;
			while ( (b = fin.read()) != -1) {
				fout.write(b);
			}
			
			fout.flush();
			System.out.println("Finish");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(System.currentTimeMillis() - start);
		
	}
}

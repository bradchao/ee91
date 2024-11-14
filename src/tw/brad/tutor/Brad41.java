package tw.brad.tutor;

import java.io.FileOutputStream;

public class Brad41 {

	public static void main(String[] args) {
		String mesg = "Hello, World";
		
		try(FileOutputStream fout = new FileOutputStream("dir1/file2.txt")){
			
			fout.write(mesg.getBytes());
			
			System.out.println("OK");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}

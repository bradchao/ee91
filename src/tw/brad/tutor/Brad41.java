package tw.brad.tutor;

import java.io.FileOutputStream;

public class Brad41 {

	public static void main(String[] args) {
		String mesg = "abcdefg";
		
		try(FileOutputStream fout = new FileOutputStream("dir1/file2.txt", true)){
			
			fout.write(mesg.getBytes());
			
			System.out.println("OK");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

}

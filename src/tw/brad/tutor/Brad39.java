package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad39 {

	public static void main(String[] args) {
		try (FileInputStream fin = new FileInputStream("dir1/file1.txt");){
			int len; byte[] buf = new byte[3];
			
			while ( (len = fin.read(buf)) != -1 ) {
				System.out.print(new String(buf,0,len));
			}
			
			System.out.println();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

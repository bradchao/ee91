package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad40 {

	public static void main(String[] args) {
		File source = new File("dir1/file1.txt");
		try (FileInputStream fin = new FileInputStream(source);){
			int len; byte[] buf = new byte[(int)source.length()];
			fin.read(buf);
			System.out.println(new String(buf));
			
			System.out.println();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

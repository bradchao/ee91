package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Brad38 {

	public static void main(String[] args) {
		try (FileInputStream fin = new FileInputStream("dir1/file1.txt");){
			int c;
			while ( (c = fin.read()) != -1 ) {
				System.out.print((char)c);
			}
			
			System.out.println();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

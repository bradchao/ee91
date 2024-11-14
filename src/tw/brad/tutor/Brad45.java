package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad45 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		File source = new File("dir1/coffee.jpg");
		File target = new File("dir4/brad.jpg");
		try (FileInputStream fin = new FileInputStream(source);
				FileOutputStream fout = new FileOutputStream(target);){
			
			byte[] buf = new byte[4*1024];
			int len;
			while ( (len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}

			System.out.println("Finish2");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(System.currentTimeMillis() - start);

	}

}

package tw.brad.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Brad44 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		File source = new File("dir1/coffee.jpg");
		File target = new File("dir3/brad.jpg");
		try (FileInputStream fin = new FileInputStream(source);
				FileOutputStream fout = new FileOutputStream(target);){
			
			byte[] buf = new byte[(int)source.length()];
			fin.read(buf);
			fout.write(buf);
			fout.flush();

			System.out.println("Finish");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(System.currentTimeMillis() - start);

	}

}

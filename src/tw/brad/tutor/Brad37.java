package tw.brad.tutor;

import java.io.File;

public class Brad37 {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
		
		File file1 = new File("c:/brad/dir2");
		File file2 = new File("c:/brad/test1");
		System.out.println(file1.exists());
		System.out.println(file2.exists());
		
		File file3 = new File("./dir3");
		if (!file3.exists()) {
			if (file3.mkdir()) {
				System.out.println("OK");
			}else {
				System.out.println("XX");
			}
		}
		
	}

}

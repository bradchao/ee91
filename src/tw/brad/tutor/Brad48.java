package tw.brad.tutor;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import tw.brad.apis.Student;

public class Brad48 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/student.s1");
			ObjectInputStream oin = new ObjectInputStream(fin);
			
			while (true) {
				try {
					Student s1 = (Student)oin.readObject();
					System.out.printf("%s: %d, %f\n", s1.getName(), s1.score(), s1.avg());
				}catch(EOFException e) {
					break;
				}
			}
			
			oin.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

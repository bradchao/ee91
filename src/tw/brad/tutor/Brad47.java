package tw.brad.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.brad.apis.Student;

public class Brad47 {

	public static void main(String[] args) {
		Student s1 = new Student("Brad", 70, 40, 50);
		System.out.printf("%s: %d, %f\n", s1.getName(), s1.score(), s1.avg());
		Student s2 = new Student("Tony", 90, 80, 100);
		System.out.printf("%s: %d, %f\n", s2.getName(), s2.score(), s2.avg());
		
		try {
			FileOutputStream fout = new FileOutputStream("dir1/student.s1");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			
			oout.writeObject(s1);
			oout.writeObject(s2);
			
			oout.flush();
			oout.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}

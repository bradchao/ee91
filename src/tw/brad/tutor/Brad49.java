package tw.brad.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Brad49 {
	public static void main(String[] args) {
		Brad493 obj = new Brad493();
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir1/test.obj"));
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("OK1");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("---");
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir1/test.obj"));
			oin.readObject();
			oin.close();
			System.out.println("OK2");
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}
}
class Brad491 implements Serializable{
	Brad491(){System.out.println("Brad491()");}
}
class Brad492 extends Brad491 {
	Brad492(){System.out.println("Brad492()");}
}
class Brad493 extends Brad492 {
	Brad493(){System.out.println("Brad493()");}
	
}

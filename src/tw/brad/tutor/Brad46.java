package tw.brad.tutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Brad46 {

	public static void main(String[] args) {
		try (FileReader fr = new FileReader("dir1/ns1hosp.csv");
			BufferedReader reader = new BufferedReader(fr);){
			
			String line;
			while ( (line = reader.readLine()) != null) {
				String[] data = line.split(",");
				System.out.println(data[2]);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

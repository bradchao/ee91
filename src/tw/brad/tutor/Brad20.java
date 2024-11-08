package tw.brad.tutor;

import tw.brad.apis.Bike;
import tw.brad.apis.Scooter;

public class Brad20 {
    public static void main(String[] args){
        String s0 = "Brad";
        String s1 = new String();
        byte[] b1 = {97,98,99,100,101,102};
        String s2 = new String(b1);
        String s3 = new String(b1, 2, 3);

        System.out.println(s0);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        Bike bike = new Bike();
        System.out.println(bike);

        Scooter scooter = new Scooter();
        System.out.println(scooter);

        Object obj = new Object();
        System.out.println(obj);

    }
}

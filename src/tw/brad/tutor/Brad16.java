package tw.brad.tutor;

import tw.brad.apis.*;

public class Brad16 {
    public static void main(String[] args){
        Scooter s1 = new Scooter();

        //Scooter s2 = new Scooter(12.3);
        System.out.println(s1.getSpeed());
        s1.upSpeed().upSpeed().upSpeed().upSpeed().downSpeed();
        System.out.println(s1.getSpeed());
    }
}

package tw.brad.tutor;

import tw.brad.apis.Bike;
import tw.brad.apis.Scooter;

public class Brad18 {
    public static void main(String[] args){
        Bike b1 = new Bike();
        Bike b2 = new Scooter();
        Scooter s1 = new Scooter();

        b1.upSpeed();
        b2.upSpeed();
        s1.changeGear(2);

        Scooter s2 = (Scooter) b2;
        s2.changeGear(1);

        m1(s1);

    }

    static void m1(Bike bike){
        bike.upSpeed();
    }


}

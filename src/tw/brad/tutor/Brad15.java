package tw.brad.tutor;

import tw.brad.apis.Bike;

public class Brad15 {
    public static  void main(String[] args){
        Bike b1 = new Bike();
        Bike b2 = new Bike(12.3);
        System.out.println(b1.getSpeed());
        b1.upSpeed();
        b1.upSpeed();
        b1.upSpeed();
        b1.upSpeed();
        System.out.println(b1.getSpeed());
        b1.downSpeed();
        System.out.println(b1.getSpeed());
        b2.upSpeed();
        System.out.println(b2.getSpeed());
    }
}

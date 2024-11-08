package tw.brad.apis;

public class Scooter extends Bike{
    private int gear;   // 0
//    @Override
//    public void upSpeed() {
//        speed = speed < 1? 1: speed * 1.7;
//    }

    public boolean changeGear(int gear){
        if (gear >= 0 && gear <= 4){
            this.gear = gear;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Scooter upSpeed() {
        speed = speed < 1? 1: speed * 1.7 * gear;
        return this;
    }

    @Override
    public String toString() {
        return String.format("speed: %f, gear = %d", speed, gear);
    }
}

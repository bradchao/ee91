package tw.brad.apis;

public class Bike extends Object{
    protected double speed;

    public Bike(){
        System.out.println("Bike()");
    }
    public Bike(double speed){
        System.out.println("Bike(double)");
        this.speed = speed;
    }

    public Bike upSpeed(){
        speed = speed < 1? 1: speed * 1.4;
        return this;
    }

    public void downSpeed(){
        speed = speed < 1? 0: speed*0.7;
    }

    public double getSpeed(){
        return speed;
    }

}

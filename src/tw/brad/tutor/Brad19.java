package tw.brad.tutor;

public class Brad19 {
    public static void main(String[] args){
        Brad193 obj1 = new Brad193();
        System.out.println("---");
        Brad193 obj2 = new Brad193(1);
        System.out.println("---");
        Brad193 obj3 = new Brad193(1.2);
    }
}

class Brad191 extends Object{
    Brad191(){
        // super();
        System.out.println("Brad191()");
    }
}
class Brad192 extends Brad191 {
//    Brad192(){
//        // super();
//        System.out.println("Brad192()");
//    }
    Brad192(int b){
        System.out.println("Brad192(int)");
    }
}
class Brad193 extends Brad192 {
    Brad193(){
        // super()
        super(2);
        //this(1.3);
        System.out.println("Brad193()");
    }
    Brad193(int a){
        // super();
        //super(3);
        this();
        System.out.println("Brad193(int)");
    }
    Brad193(double b){
        this(2);
        System.out.println("Brad193(double)");
    }
}

package tw.brad.tutor;

import tw.brad.apis.TWId;

public class Brad22 {
    public static void main(String[] args){
        String id = "A123456789";
        if (TWId.isRight(id)) {
        	System.out.println("OK");
        }else {
        	System.out.println("XX");
        }
        System.out.println("---");
        TWId id1 = new TWId();
        TWId id2 = new TWId(true);
        TWId id3 = new TWId('T');
        TWId id4 = new TWId(false, 'B');
        TWId id5 = TWId.createTWId("A123456787");
        
        System.out.println(id1);
        System.out.println(id2.getId());
        System.out.println(id3);
        System.out.println(id4);
        System.out.println(id5);
        System.out.println("----");
        System.out.println(TWId.letters);
        System.out.println(Math.PI);
        
        
    }
}

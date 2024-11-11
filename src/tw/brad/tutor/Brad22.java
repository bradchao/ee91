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
    }
}

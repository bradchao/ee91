package tw.brad.apis;

import java.util.Random;

public class TWId extends Object{
    private String id;
    public static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";

    public TWId(){
        this((int)(Math.random()*2)==0);
    }
    public TWId(boolean isMale){
        this(isMale, letters.charAt(new Random().nextInt(26)));
    }
    public TWId(char area){
        this((int)(Math.random()*2)==0, area);
    }
    public TWId(boolean isMale, char area){
    	StringBuffer sb = new StringBuffer();
    	sb.append(area);
    	sb.append(isMale?'1':'2');
    	for (int i=0; i<7; i++) sb.append(new Random().nextInt(10));
    	
    	for (int i=0; i<10; i++) {
    		if (isRight(sb.toString() + i)) {
    			id = sb.toString() + i;
    			break;
    		}
    	}
    	
    }
    //---------------------------------
    public TWId(String id) throws Exception {
    	if (isRight(id)) {
    		this.id = id;
    	}else {
    		throw new Exception("ID ERROR");
    	}
    }
    
//    private TWId(String id){
//        this.id = id;
//    }
//    
//    public static TWId createTWId(String id) {
//    	if (isRight(id)) {
//    		return new TWId(id);
//    	}else {
//    		return null;
//    	}
//    }
    
    public String getId() {
    	return id;
    }
    
    public String getArea() {
    	return "台中市";
    }
    public boolean isMale() {
    	return true;
    }
    
    public String toString() {
    	return id;
    }

    public static boolean isRight(String id){
        boolean isRight = false;
//        if (id.length() == 10){
//            char c1 = id.charAt(0);
//            if (letters.indexOf(c1) != -1){
//                if (id.charAt(1) == '1' || id.charAt(1) == '2'){
//                }
//            }
//
//        }

        if (id.matches("[A-Z][12][0-9]{8}")){
            //isRight = true;
        	char c1 = id.charAt(0);
        	int a12 = letters.indexOf(c1) + 10;
        	int a1 = a12 / 10;
        	int a2 = a12 % 10;
        	//System.out.printf("a1 = %d, a2 = %d", a1, a2);
        	
        	String s1 = id.substring(1,2);
        	int n1 = Integer.parseInt(s1);
        	int n2 = Integer.parseInt(id.substring(2, 3));
        	int n3 = Integer.parseInt(id.substring(3, 4));
        	int n4 = Integer.parseInt(id.substring(4, 5));
        	int n5 = Integer.parseInt(id.substring(5, 6));
        	int n6 = Integer.parseInt(id.substring(6, 7));
        	int n7 = Integer.parseInt(id.substring(7, 8));
        	int n8 = Integer.parseInt(id.substring(8, 9));
        	int n9 = Integer.parseInt(id.substring(9, 10));
        	
        	int sum = a1*1 + a2*9 + n1*8 + n2*7 + n3*6 + n4*5
        			+ n5*4 + n6*3 + n7*2 + n8*1 + n9*1;
        	isRight = sum % 10 == 0;
        	
        }

        return isRight;
    }



}

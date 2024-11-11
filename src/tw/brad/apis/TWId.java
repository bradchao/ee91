package tw.brad.apis;

public class TWId {
    private String id;

    public TWId(){
        this((int)(Math.random()*2)==0);
    }
    public TWId(boolean isMale){
        this(isMale, 'A');
    }
    public TWId(char area){
        this((int)(Math.random()*2)==0, 'A');
    }
    public TWId(boolean isMale, char area){

    }
    private TWId(String id){
        this.id = id;
    }

    public static boolean isRight(String id){
        boolean isRight = false;
        String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
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
        	
        	
        	
        }

        return isRight;
    }



}

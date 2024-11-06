package tw.brad.tutor;

public class Brad10 {
    public static void main(String[] args){
        int[] ary1;
        ary1 = new int[3];  // 0:0, 1:0, 2:0
        System.out.println(ary1.length);
        System.out.println("----");
        ary1[0] = 12;
        ary1[1] = 777;
        ary1[2] = 14;
        for(int i=0; i< ary1.length; i++){
            System.out.println(ary1[i]);
        }
        System.out.println("----");
        for (int value : ary1){     // for-each
            System.out.println(value);
        }
    }
}

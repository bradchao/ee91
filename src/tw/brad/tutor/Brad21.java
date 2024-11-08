package tw.brad.tutor;

public class Brad21 {
    public static void main(String[] args){
        String s1 = "Brad";
        String s2 = new String("Brad");
        String s3 = new String(s1);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s1);

        System.out.println("Brad".charAt(0));

        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
        System.out.println(s3.equals(s1));


    }
}

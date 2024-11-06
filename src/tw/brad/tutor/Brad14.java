package tw.brad.tutor;

public class Brad14 {
    public static void main(String[] args){
        int a = -10, b = 4;

        a = a ^ b;  // a = 13
        b = a ^ b;  // b = 10
        a = a ^ b;  // a = 3

        System.out.printf("a = %d, b = %d\n", a, b);

        int v1 = 3, v2 = 2;
        System.out.println(v1 & v2);
        System.out.println(v1 | v2);
        System.out.println(v1 ^ v2);

    }
}

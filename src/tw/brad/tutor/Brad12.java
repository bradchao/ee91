package tw.brad.tutor;

public class Brad12 {
    public static void main(String[] args){
        int[] p = new int[7];   // [0]:0, [1]:0,....[6]:0

        for (int i=0; i<1000000; i++){
            int point = (int)(Math.random()*9)+1;
            if (point >=1 && point <=9){
                p[point>6?point-3:point]++;
            }else{
                p[0]++;
            }
        }
        if (p[0] > 0){
            System.out.println("ERROR");
        }else {
            for (int i=1; i<p.length; i++){
                System.out.printf("%d點出現 %d 次\n", i, p[i]);
            }
        }

    }
}

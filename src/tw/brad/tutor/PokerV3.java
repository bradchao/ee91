package tw.brad.tutor;

import java.util.Arrays;

public class PokerV3 {
    public static void main(String[] args){
        final int nums = 52;
        int[] poker = new int[nums];
        for (int i=0; i<poker.length; i++) poker[i] = i;

        for (int i=nums-1; i>0; i--){
            int rand = (int)(Math.random()*(i+1));
            // poker[rand] <=> poker[i]
            int temp = poker[rand];
            poker[rand] = poker[i];
            poker[i] = temp;
        }

//        for(int card:poker){
//            System.out.println(card);
//        }
//        System.out.println("---");

        int[][] players = new int[4][13];
        for (int i = 0; i< poker.length; i++){
            players[i%4][i/4] = poker[i];
        }

        //
        String[] flowers = {"黑桃","紅心","方塊","梅花"};
        String[] values = new String[]{"A ","2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10","J ","Q ","K "};
        for (int[] player  :players){
            Arrays.sort(player);
            for (int card : player){
                System.out.printf("%s%s  ", flowers[card/13], values[card%13]);
            }
            System.out.println();
        }






    }
}

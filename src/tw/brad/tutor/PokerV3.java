package tw.brad.tutor;

public class PokerV3 {
    public static void main(String[] args){
        final int nums = 52;
        int[] poker = new int[nums];
        for (int i=0; i<poker.length; i++) poker[i] = i;

        for (int i=nums-1; i>0; i--){
            int rand = (int)(Math.random()*(i+1));
            // poker[rand] <=> poker[i]
        }

    }
}

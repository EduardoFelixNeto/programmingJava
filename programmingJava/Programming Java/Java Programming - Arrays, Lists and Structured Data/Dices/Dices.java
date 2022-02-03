import java.util.Random;

public class Dices {
    public void simulate(int rolls){
        Random rand = new Random();
        int [] counts = new int [13];

        for (int k = 0; k < rolls; k++){
            int dice1 = rand.nextInt(6) + 1;
            int dice2 = rand.nextInt(6) + 1;
            //System.out.println("roll is " + dice1 + "+" + dice2 + "=" + (dice1+dice2));
            counts[dice1+dice2] += 1;
        }

        for (int k = 2; k <= 12; k++){
            System.out.println(k + "'s=\t" + counts[k] + "\t" + 100.0 * counts[k]/rolls);
        }
    }
}

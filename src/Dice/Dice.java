package Dice;


import java.util.Random;
import java.util.Arrays;


public class Dice  {
    private int roll;
    private int[] dice;
    private Random RNum;

    public int[] roll (int n){
        dice = new int[n];
        for (int i = 0; i < n; i++){
            RNum = new Random();
            roll = RNum.nextInt(6) + 1;
            dice[i] = roll;
        }
        Arrays.sort(dice);

        return dice;
    }
    public int rollForOne(){
        RNum = new Random();
        roll = RNum.nextInt(6) + 1;
        return roll;
    }
    public int maxNumDice(String s, int n)
    {
        int num = 0;
        int maxDice = 0;

        if (!s.equals("Attacker"))
            num = -1;

        if (n == (2 + num))
            maxDice = 1;
        else if (n == (3 + num))
            maxDice = 2;
        else if (n > (3 + num))
            maxDice = 3 + num;

        return maxDice;
    }

}

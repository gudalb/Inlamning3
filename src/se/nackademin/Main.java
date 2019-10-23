package se.nackademin;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        boolean[] kindOfChange = new boolean[10];

        // val av valörer
        kindOfChange[0] = true;
        kindOfChange[1] = true;
        kindOfChange[6] = true;
        kindOfChange[9] = true;

        long[] test = returnChange(kindOfChange, 2894);

        for (long l:test) System.out.println(l);
    }

    public static long[] returnChange (boolean[] denomination, float nChange) {
        long[] nOfDenomination = new long[10];
        int[] denominationValues = new int[] {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};


        for (int i = 0;i<10;i++)
        if (denomination[i] && nChange - denominationValues[i] >= 0) {
            int count = getDenominationCount(denominationValues[i], nChange);
            nOfDenomination[i] = count;
            nChange %= denominationValues[i];
        }

        return nOfDenomination;

    }

    public static int getDenominationCount (int denomination, float nChange) {
        int count = 0;
        while (nChange - denomination >= 0) {
            count++;
            nChange -= denomination;
        }

        return count;
    }
}

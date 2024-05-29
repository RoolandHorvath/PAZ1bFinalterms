package FinaltermP3_2023;

public class Prepravca {

    private boolean canPartition(int[] wagons) {

        int totalSum = 0;
        for (int i = 0; i < wagons.length; i++) {
            totalSum += wagons[i];
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int wagon: wagons) {
            for (int i = target; i >= wagon; i--) {
                dp[i] = dp[i] || dp[i - wagon];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Prepravca p = new Prepravca();
        int[] wagons = new int[]{1,5,11,5};

        if (p.canPartition(wagons)) {
            System.out.println("Dá sa");
        } else {
            System.out.println("Nedá sa");
        }
    }
}

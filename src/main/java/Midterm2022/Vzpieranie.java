package Midterm2022;

import java.util.Arrays;

public class Vzpieranie {
    private int left = 0;
    private int right = 0;
    private int bar = 20;
    private int maxWeight = 0;
    private int[] p;
    private int[] array;
    public int maximalnaCinka(int[] zavazia) {

        array = new int[zavazia.length];
        this.p = zavazia;
        generate(0);
        return maxWeight;
    }

    private void generate(int odIdx) {

        if (odIdx == p.length) {
            System.out.println(Arrays.toString(p));
            solve();
            return;
        }

        for (int i = 0; i < 3; i++) {
            array[odIdx] = i;
            generate(odIdx + 1);
        }

    }

    private void solve() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                left += p[i];
            }
            if (array[i] == 2) {
                right += p[i];
            }
        }
        int tmp = 0;
        if (left == right) {
            tmp = left + right + bar;
            if (tmp > maxWeight) {
                maxWeight = tmp;
            }
        }
        left = 0;
        right = 0;
    }

    public static void main(String[] args) {
        int[] p;
        p = new int[]{20, 5, 5, 8, 10, 6, 2};
        Vzpieranie v = new Vzpieranie();
        System.out.println(v.maximalnaCinka(p));
    }
}
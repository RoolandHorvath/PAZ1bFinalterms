package FinaltermP1_2023;

public class DovolenkaBT {
    private int M;
    private int H;
    private int m;
    private int h;
    private int[] array;
    private int output;
    public DovolenkaBT(int M1, int H1, int m1, int h1) {
        this.M = M1;
        this.H = H1;
        this.m = m1;
        this.h = h1;
        array = new int[M+H];
        if (M != 0 && H != 0) {
            generuj();
            System.out.println(output);
        } else {
            System.out.println(output);
        }
    }
    private void generuj() {
        generuj(0,0,0,0,0);
    }
    private void generuj(int odIdx, int totalDaysAtSea, int totalDaysAtMountains, int consecutiveSea, int consecutiveMountains) {

        if (totalDaysAtSea + (array.length - odIdx) < M) {
            return;
        }

        if (totalDaysAtMountains + (array.length - odIdx) < H) {
            return;
        }

        if (odIdx == array.length) {
            if (totalDaysAtSea == M && totalDaysAtMountains == H) {
                output++;
            }
            return;
        }


        if (totalDaysAtSea < M && consecutiveSea < m) {
            array[odIdx] = 0;
            generuj(odIdx + 1, totalDaysAtSea+1, totalDaysAtMountains, consecutiveSea+1, 0);
        }

        if (totalDaysAtMountains < H && consecutiveMountains < h) {
            array[odIdx] = 1;
            generuj(odIdx + 1, totalDaysAtSea, totalDaysAtMountains+1, 0, consecutiveMountains+1);
        }
    }

    public static void main(String[] args) {
        DovolenkaBT dbt = new DovolenkaBT(2,1,1,8);
        DovolenkaBT dbt2 = new DovolenkaBT(2,3,1,2);
        DovolenkaBT dbt3 = new DovolenkaBT(2,4,1,1);
    }
}
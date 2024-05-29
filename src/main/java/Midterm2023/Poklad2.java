package Midterm2023;

import java.util.ArrayList;
import java.util.List;

public class Poklad2 {


    private List<String> moznosti;
    private int dolava = 0;
    private int doprava = 0;
    private int hore = 0;
    private int dole = 0;
    private int xo, yo, k;
    private int[] pole;


    public List<String> cesty(int k, int x, int y) {
        moznosti = new ArrayList<>();
        this.k = k;
        this.xo = x;
        this.yo = y;
        pole = new int[k];
        generuj(0);
        return moznosti;
    }

    public void vytvor() {
        int x = xo;
        int y = yo;
        StringBuilder sb = new StringBuilder();
        int pocetKrokov = 0;
        for (int i = 0; i < pole.length; i++) {
            if (pole[i] == 0 && y != 0) {
                sb.append("S");
                y -= 1;
                pocetKrokov++;
            }
            if (pole[i] == 1 && y != 0) {
                sb.append("J");
                y += 1;
                pocetKrokov++;
            }
            if (pole[i] == 2 && x != 0) {
                sb.append("Z");
                x -= 1;
                pocetKrokov++;
            }
            if (pole[i] == 3 && x != 0) {
                sb.append("V");
                x += 1;
                pocetKrokov++;
            }

            if (pocetKrokov == k && x + y == 0) {
                moznosti.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        //System.out.println(moznosti);
    }

    public void generuj(int odIdx) {
        if (odIdx == pole.length) {
            vytvor();
            return;
        }

        pole[odIdx] = 0;
        generuj(odIdx + 1);
        pole[odIdx] = 1;
        generuj(odIdx + 1);
        pole[odIdx] = 2;
        generuj(odIdx + 1);
        pole[odIdx] = 3;
        generuj(odIdx + 1);
    }

    public static void main(String[] args) {
        Poklad2 p = new Poklad2();
        System.out.println(p.cesty(3, 2, 1));
    }

}


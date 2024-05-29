package Midterm2017;

import java.util.HashSet;
import java.util.Set;

public class Vyskrtavacka {

    // Privátne premenné a konštruktor s ktorým budem robiť
    private Set<Integer> output = new HashSet<>();
    private int[] onesAndZeroes;
    private int[] numArray;
    private int number;
    // V konštruktore si zistím počet cifier v čísle, a odzadu si tieto cifry postupne poukladám do numArray
    public Vyskrtavacka(int cislo) {

        this.number = cislo;
        int n1 = cislo;
        int n2 = cislo;
        int digitCount = 0;
        while (n1 > 0) {
            digitCount++;
            n1 /= 10;
        }
        onesAndZeroes = new int[digitCount];
        numArray = new int[digitCount];
        for (int i = numArray.length - 1; i >= 0; i--) {
            numArray[i] = n2 % 10;
            n2 /= 10;
        }

    }
    // Generujem 0 a 1
    public Set<Integer> generuj() {

        generuj(0);
        return output;
    }
    private void generuj(int odIdx) {

        if (odIdx == onesAndZeroes.length) {
            spracuj();
            return;
        }

        for (int i = 0; i <= 1; i++) {
            onesAndZeroes[odIdx] = i;
            generuj(odIdx + 1);
        }
    }
    // Zisťujem každú možnú unikátnu kombináciu čísel ktoré viem vytvoriť vyškrtaním pôvodného čísla, a na konci
    // overím či nájdené číslo je > 0 a zároveň < ako pôvodné číslo
    public void spracuj() {
        int pwr = 0;
        int result = 0;
        for (int i = onesAndZeroes.length - 1; i >= 0; i--) {
            if (onesAndZeroes[i] == 0) {
                result += numArray[i] * (int) Math.pow(10, pwr);
                pwr++;
            }

        }
        if (result > 0 && result < number) {
            output.add(result);
        }
    }

    public static void main(String[] args) {
        Vyskrtavacka v = new Vyskrtavacka(245);
        System.out.println(v.generuj());
    }
}
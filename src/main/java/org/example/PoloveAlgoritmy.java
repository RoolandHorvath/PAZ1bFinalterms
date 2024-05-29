package org.example;

public class PoloveAlgoritmy {

//    public static boolean vsetkyRovnake(int[] p, int odIdx, int poIdx) {
//        for (int i = odIdx + 1; i <= poIdx; i++)
//            if (p[odIdx] != p[i])
//                return false;
//
//        return true;
//    }

    public static boolean vsetkyRovnake(int[] p, int odIdx, int poIdx) {
        // Ak odIdx == poIdx (inými slovami - ak sme prešli celým poľom bez toho aby nám if podmienka o jedno nižšie
        // vrátilo false), tak vráti true
        if (odIdx == poIdx){
            return true;
        }
        // Index v polovici poľa
        int midIdx = odIdx + (poIdx - odIdx) / 2;
        // Ak dva konkrétne prvky na p[odIdx] a p[poIdx] sa nerovnajú, tak vráti false
        if (p[odIdx] != p[poIdx]) {
            return false;
        }
        // Rekurzívne volanie prvej a druhej polovice poľa + kontrola či stredný prvok sa rovná s
        // ďalším prvkom pre prípad že pole má nepárny počet prvkov
        return vsetkyRovnake(p,odIdx,midIdx) && vsetkyRovnake(p, midIdx+1, poIdx) && p[midIdx] == p[midIdx + 1];
    }
}

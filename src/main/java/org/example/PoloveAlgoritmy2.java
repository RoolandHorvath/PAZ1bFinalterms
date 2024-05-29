package org.example;

public class PoloveAlgoritmy2 {
//    public static boolean maMaleRozdiely(int[] p, int odIdx, int poIdx, int rozdiel) {
//
//        for (int i = odIdx; i < poIdx; i++)
//            if (Math.abs(p[i + 1] - p[i]) > rozdiel)
//                return false;
//
//        return true;
//    }

    public static boolean maMaleRozdiely(int[] p, int odIdx, int poIdx, int rozdiel) {

        int stredIdx = odIdx + poIdx / 2;

        // Kontrolujem prípady pre 1-prvkové a 2-prvkové pole, 1-prvkové len vrátim, 2-prvkové porovnám oba prvky a vrátim true
        // ak sedí kontrola

        if (p.length == 1) return true;
        if (p.length == 2) {

            if (Math.abs(p[poIdx] - p[odIdx]) < rozdiel) {
                return true;
            } else return false;

        }

        return (maMaleRozdiely(p, odIdx, stredIdx, rozdiel) && maMaleRozdiely(p, stredIdx, poIdx, rozdiel));


    }
}

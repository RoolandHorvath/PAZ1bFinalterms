package Midterm2022;

import java.util.*;
public class Sekretarky {
    private String meno;
    private List<Sekretarky> deti = new ArrayList<>();

    public Sekretarky(String meno) {
        this.meno = meno;
    }

    public void pridajDieta(Sekretarky dieta) {
        deti.add(dieta);
    }

    public void vypisRodostrom() {
        vypisRodostrom(0);
    }

    public void vypisRodostrom(int level) {
        for (int i = 0; i < level; i++)
            System.out.print(' ');
        System.out.println(meno);
        for (Sekretarky dieta : deti)
            dieta.vypisRodostrom(level + 1);
    }

    public int pocetSekretarok() {
        return helper(this, false);
    }

    public int helper(Sekretarky dieta, boolean parentHasNonLeafChild) {

        int output = 0;
        boolean hasNonLeafChild = false;
        boolean allChildrenAreLeaves = true;

        for (Sekretarky child: dieta.deti) {
            if (!child.deti.isEmpty()) {
                hasNonLeafChild = true;
                allChildrenAreLeaves = false;
                break;
            }
        }

        for (Sekretarky child: dieta.deti) {
            if (child.deti.isEmpty() && !allChildrenAreLeaves) {
                output++;
            }
            output += helper(child, hasNonLeafChild);

        }
        return output;
    }


    public static void main(String[] args) {
        Sekretarky a = new Sekretarky("a");
        Sekretarky b = new Sekretarky("b");
        Sekretarky c = new Sekretarky("c");
        Sekretarky d = new Sekretarky("d");
        Sekretarky e = new Sekretarky("e");
        Sekretarky f = new Sekretarky("f");
        Sekretarky g = new Sekretarky("g");
        Sekretarky h = new Sekretarky("h");

        a.pridajDieta(b);
        a.pridajDieta(c);
        a.pridajDieta(d);
        b.pridajDieta(e);
        b.pridajDieta(f);

        System.out.println("Pred: ");
        a.vypisRodostrom();
        System.out.println("Po: ");
        System.out.println(a.pocetSekretarok());
    }
}

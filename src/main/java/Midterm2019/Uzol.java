package Midterm2019;

import java.util.*;

public class Uzol {

    private String meno;
    private List<Uzol> deti = new ArrayList<>();

    public Uzol(String meno) {
        this.meno = meno;
    }

    public void pridajDieta(Uzol dieta) {
        deti.add(dieta);
    }

    public void vypisRodostrom() {
        vypisRodostrom(0);
    }

    public void vypisRodostrom(int level) {
        for (int i = 0; i < level; i++)
            System.out.print(' ');
        System.out.println(meno);
        for (Uzol dieta : deti)
            dieta.vypisRodostrom(level + 1);
    }

    public int pocetMenovcov(String meno) {
        int output = 0;

        for(Uzol child: deti) {
            if (child.meno.equals(meno)) {
                output++;
            }
            output += child.pocetMenovcov(meno);
        }
        return output;
    }
    public int pocetMenovcov() {

        return pocetMenovcov(this.meno);
    }

    public static void main(String[] args) {
        Uzol a = new Uzol("a");
        Uzol b = new Uzol("b");
        Uzol c = new Uzol("c");
        Uzol a2 = new Uzol("a");
        Uzol a3 = new Uzol("a");

        a.pridajDieta(b);
        a.pridajDieta(c);
        b.pridajDieta(a2);
        c.pridajDieta(a3);

        System.out.println(a.pocetMenovcov());
    }
}
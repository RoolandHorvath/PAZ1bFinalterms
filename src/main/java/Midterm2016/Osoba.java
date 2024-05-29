package Midterm2016;

import java.util.*;
public class Osoba {
    private String meno;
    private List<Osoba> deti = new ArrayList<>();
    public Osoba(String meno) {
        this.meno = meno;
    }
    public void pridajDieta(Osoba dieta) {
        deti.add(dieta);
    }
    public void vypisRodostrom() {
        vypisRodostrom(0);
    }
    public void vypisRodostrom(int level) {
        for (int i = 0; i < level; i++)
            System.out.print(' ');
        System.out.println(meno);
        for (Osoba dieta : deti)
            dieta.vypisRodostrom(level + 1);
    }
    public int pocetRodicovBezVnukov() {

        int output = 0;
        boolean allChildrenAreLeafs = true;
        for(Osoba child: this.deti) {

            if (!child.deti.isEmpty()) {
                allChildrenAreLeafs = false;
                break;
            }
        }
        if (!this.deti.isEmpty() && allChildrenAreLeafs) {
            output += 1;
        }
        for (Osoba child: this.deti) {
            output += child.pocetRodicovBezVnukov();
        }
        return output;
    }

    public static void main(String[] args) {
        Osoba a = new Osoba("a");
        Osoba b = new Osoba("b");
        Osoba c = new Osoba("c");
        Osoba d = new Osoba("d");
        Osoba e = new Osoba("e");
        Osoba f = new Osoba("f");

        a.pridajDieta(b);
        a.pridajDieta(c);
        a.pridajDieta(d);
        b.pridajDieta(e);
        b.pridajDieta(f);

        System.out.println(a.pocetRodicovBezVnukov());
    }
}
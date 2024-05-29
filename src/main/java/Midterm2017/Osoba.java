package Midterm2017;

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
    public int vratMaxPocetDeti() {

        int output = deti.size();

        for(Osoba child: deti) {

            int tmp = child.vratMaxPocetDeti();
            if (tmp > output) {
                output = tmp;
            }
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
        Osoba g = new Osoba("g");
        Osoba h = new Osoba("h");
        Osoba i = new Osoba("i");

        a.pridajDieta(b);
        a.pridajDieta(c);
        a.pridajDieta(d);
        b.pridajDieta(e);
        b.pridajDieta(f);
        c.pridajDieta(g);
        d.pridajDieta(h);
        d.pridajDieta(i);
        System.out.println(a.vratMaxPocetDeti());
    }
}
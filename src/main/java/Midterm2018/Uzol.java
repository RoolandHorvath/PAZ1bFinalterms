package Midterm2018;

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

    public boolean rovnakyPocetDeti() {

        int rootChildCount = this.deti.size();
        return checkNumOfChildren(rootChildCount);
    }

    public boolean checkNumOfChildren(int rootChildCount) {

        if (!this.deti.isEmpty()) {
            if (this.deti.size() != rootChildCount) {
                return false;
            }

            for (Uzol child: deti) {
                if (!child.checkNumOfChildren(rootChildCount)) {
                    return false;
                }
            }
        }
        return true;
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

        System.out.println(a.rovnakyPocetDeti());

    }
}
package FinaltermP1_2024;

import java.util.*;

public class Osoba {
    /**
     * Meno osoby
     */
    private String meno;
    private boolean bool1;
    private boolean bool2;
    private boolean bool3;
    /**
     * Zoznam deti osoby
     */
    private List<Osoba> deti = new ArrayList<Osoba>();

    /**
     * Konstruktor osoby v strome potomkov
     *
     * @param meno meno osoby
     */
    public Osoba(String meno, boolean bool1, boolean bool2, boolean bool3) {
        this.meno = meno;
        this.bool1 = bool1;
        this.bool2 = bool2;
        this.bool3 = bool3;
    }

    /**
     * Prida osobe dieta
     *
     * @param dieta referencia na pridavane dieta
     */
    public void pridajDieta(Osoba dieta) {
        deti.add(dieta);
    }

    /**
     * Vrati celkovy pocet potomkov osoby
     */
    public int pocetPotomkov() {
        int pocetPotomkovDeti = 0;
        for (Osoba dieta : deti)
            pocetPotomkovDeti += dieta.pocetPotomkov();

        return pocetPotomkovDeti + deti.size();
    }

    public int pocetGeneracii() {
        if (deti.size() == 0)
            return 0;

        int maximalnyPocetGeneracii = 0;
        for (Osoba dieta : deti) {
            maximalnyPocetGeneracii = Math.max(maximalnyPocetGeneracii, dieta.pocetGeneracii());
        }
        maximalnyPocetGeneracii++;
        return maximalnyPocetGeneracii;
    }

    public void pridajDoZoznamu(List<Osoba> zoznam) {
        zoznam.add(this);
        for (Osoba dieta : deti) {
            dieta.pridajDoZoznamu(zoznam);
        }
    }

    /**
     * Vypise rodostrom osoby
     */
    public void vypisRodostrom() {
        System.out.println(meno);
        for (Osoba dieta : deti)
            dieta.vypisRodostrom();
    }


    private int strykoZLazov() {
        int result = 0;
        result += strykoZLazov(this);
        return result;
    }

    private int strykoZLazov(Osoba root) {
        int total = 0;
        if (!root.deti.isEmpty()) {
            for (Osoba child : deti) {
                if (!child.deti.isEmpty()) {
                    if ((child.bool1 == root.bool1) && (child.bool2 == root.bool2) && (child.bool3 == root.bool3)) {
                        total = 1;
                    }
                }
            }
            for (Osoba child : root.deti) {
                total += strykoZLazov(child);
            }
        }
        return total;
    }

    /**
     * Main s vytvorenim stromu potomkov pre Janka
     */
    public static void main(String[] args) {

        Osoba a = new Osoba("a", true, false, false);
        Osoba b = new Osoba("b", false, false, true);
        Osoba c = new Osoba("c", true, false, true);
        Osoba d = new Osoba("d", true, false, false);
        Osoba e = new Osoba("e", true, true, true);

        a.pridajDieta(b);
        a.pridajDieta(c);
        c.pridajDieta(d);
        c.pridajDieta(e);

        System.out.println(a.strykoZLazov());
    }
}

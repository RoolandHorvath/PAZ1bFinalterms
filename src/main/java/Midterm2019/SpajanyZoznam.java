package Midterm2019;

public class SpajanyZoznam {

    private static class Uzol {
        double hodnota;
        Uzol dalsi;
    }

    private Uzol prvy = null;

    public void pridajNaZaciatok(double hodnota) {
        Uzol pridavany = new Uzol();
        pridavany.hodnota = hodnota;
        pridavany.dalsi = prvy;
        prvy = pridavany;
    }

    @Override
    public String toString() {
        String vysledok = "[";
        Uzol aktualny = prvy;
        while (aktualny != null) {
            if (aktualny != prvy)
                vysledok += ", ";

            vysledok += aktualny.hodnota;
            aktualny = aktualny.dalsi;
        }
        return vysledok + "]";
    }


    public void odstrihniNa(int hodnota) {

        Uzol last = null;
        Uzol beforeLast = null;
        Uzol aktualny = prvy;
        Uzol previous = null;

        while (aktualny.dalsi != null) {

            if (aktualny.hodnota == hodnota) {
                beforeLast = previous;
                last = aktualny;
            }
            previous = aktualny;
            aktualny = aktualny.dalsi;
        }

        if (beforeLast != null) {
            beforeLast.dalsi = null;
        } else if (last == prvy) {
            prvy = null;
        }
    }

    public static void main(String[] args) {
        SpajanyZoznam zoznam = new SpajanyZoznam();
        zoznam.pridajNaZaciatok(8);
        zoznam.pridajNaZaciatok(6);
        zoznam.pridajNaZaciatok(1);
        zoznam.pridajNaZaciatok(6);
        zoznam.pridajNaZaciatok(34);
        zoznam.pridajNaZaciatok(12);
        System.out.println("Pred: " + zoznam);
        zoznam.odstrihniNa(6);
        System.out.println("Po: " + zoznam);
    }
}
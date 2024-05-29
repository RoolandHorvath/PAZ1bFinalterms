package Midterm2023;
// 2023
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


    public void priemer() {

        Uzol aktualny = prvy;

        while (aktualny != null && aktualny.dalsi != null && aktualny.dalsi.dalsi != null) {

            double average = (aktualny.hodnota + aktualny.dalsi.hodnota + aktualny.dalsi.dalsi.hodnota) / 3;
            aktualny.hodnota = average;
            aktualny.dalsi = aktualny.dalsi.dalsi.dalsi;
            aktualny = aktualny.dalsi;
        }
        if (aktualny != null && aktualny.dalsi != null) {

            double average = (aktualny.hodnota + aktualny.dalsi.hodnota) / 2;
            aktualny.hodnota = average;
            aktualny.dalsi = null;
        }
    }
    public void odstrihniNa(double hodnota) {
        Uzol zapamatany = new Uzol();
        Uzol aktualny = prvy;


        while (aktualny.dalsi != null) {

            if (aktualny.hodnota == hodnota) {
                zapamatany = aktualny;
            }

            aktualny = aktualny.dalsi;

        }

        zapamatany.dalsi = null;

    }

    public static void main(String[] args) {
        SpajanyZoznam zoznam = new SpajanyZoznam();
        zoznam.pridajNaZaciatok(8.0);
        zoznam.pridajNaZaciatok(6.0);
        zoznam.pridajNaZaciatok(1.0);
        zoznam.pridajNaZaciatok(3.0);
        zoznam.pridajNaZaciatok(5.0);
        System.out.println("Zoznam pred: " + zoznam);
        //zoznam.priemer();
        zoznam.odstrihniNa(1.0);
        System.out.println("Zoznam po: " + zoznam);
    }
}
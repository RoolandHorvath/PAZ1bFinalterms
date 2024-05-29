package Midterm2018;

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


    public void odstranCyklickyPrefix(int[] prefix) {

        if (prefix == null) {
            prvy = null;
        }
        int count = 1;
        if (prvy.hodnota == prefix[0]) {
            prvy = prvy.dalsi;
        }
        while (prvy != null) {

            if (count > prefix.length - 1) {
                count = 0;
            }
            if (prvy.hodnota == prefix[count]) {
                prvy = prvy.dalsi;
            } else {
                break;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        SpajanyZoznam zoznam = new SpajanyZoznam();
        zoznam.pridajNaZaciatok(1);
        zoznam.pridajNaZaciatok(7);
        zoznam.pridajNaZaciatok(4);
        zoznam.pridajNaZaciatok(8);
        zoznam.pridajNaZaciatok(5);
        zoznam.pridajNaZaciatok(4);
        zoznam.pridajNaZaciatok(8);

        System.out.println("Pred: " + zoznam);
        int[] p = new int[]{8,4,5};
        zoznam.odstranCyklickyPrefix(p);
        System.out.println("Po: " + zoznam);

    }
}
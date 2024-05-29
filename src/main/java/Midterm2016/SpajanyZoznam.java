package Midterm2016;

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

    public void vlozUsporiadane(int hodnota) {

        Uzol newNode = new Uzol();
        newNode.hodnota = hodnota;

        if (prvy == null && prvy.hodnota >= hodnota) {
            newNode.dalsi = prvy;
            prvy = newNode;
            return;
        }

        Uzol aktualny = prvy;

        while (aktualny.dalsi != null && aktualny.dalsi.hodnota <= hodnota) {
            aktualny = aktualny.dalsi;
        }
        newNode.dalsi = aktualny.dalsi;
        aktualny.dalsi = newNode;

    }

    public static void main(String[] args) {
        SpajanyZoznam zoznam = new SpajanyZoznam();
        zoznam.pridajNaZaciatok(9);
        zoznam.pridajNaZaciatok(7);
        zoznam.pridajNaZaciatok(6);
        zoznam.pridajNaZaciatok(5);
        zoznam.pridajNaZaciatok(4);
        zoznam.pridajNaZaciatok(2);
        zoznam.pridajNaZaciatok(1);
        System.out.println("Pred: " + zoznam);
        zoznam.vlozUsporiadane(0);
        System.out.println("Po: " + zoznam);

    }
}
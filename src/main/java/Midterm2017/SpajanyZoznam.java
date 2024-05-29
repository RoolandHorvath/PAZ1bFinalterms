package Midterm2017;

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


    public void zduplikuj(int hodnota) {
        Uzol aktualny = prvy;

        while(aktualny != null) {

            if (aktualny.hodnota == hodnota) {
                Uzol newNode = new Uzol();
                newNode.dalsi = aktualny.dalsi;
                newNode.hodnota = hodnota;
                aktualny.dalsi = newNode;
                aktualny = aktualny.dalsi;
            }
            aktualny = aktualny.dalsi;
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
        zoznam.zduplikuj(8);
        System.out.println("Po: " + zoznam);

    }
}
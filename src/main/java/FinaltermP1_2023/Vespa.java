package FinaltermP1_2023;

public class Vespa {

    private static class Uzol {
        int hodnota;
        Uzol dalsi;
    }

    private Uzol prvy = null;

    public void pridajNaZaciatok(int hodnota) {
        Uzol novy = new Uzol();
        novy.hodnota = hodnota;
        novy.dalsi = prvy;
        prvy = novy;
    }

    @Override
    public String toString() {
        String s = "";
        Uzol aktualny = prvy;
        while (aktualny != null) {
            s = s + aktualny.hodnota + ", ";
            aktualny = aktualny.dalsi;
        }
        return s;
    }

    private void pridajVespu(int rok) {

        Uzol aktualny = prvy;
        boolean wasAdded = false;

        if (aktualny.hodnota > rok) {
            Uzol newNode = new Uzol();
            newNode.hodnota = rok;
            newNode.dalsi = aktualny;
            prvy = newNode;
            wasAdded = true;
        }

        while (aktualny.dalsi != null) {
            if(wasAdded) return;

            if (aktualny.dalsi.hodnota > rok && aktualny.hodnota < rok) {
                Uzol newNode = new Uzol();
                newNode.hodnota = rok;
                newNode.dalsi = aktualny.dalsi;
                aktualny.dalsi = newNode;
                wasAdded = true;
            }
            aktualny = aktualny.dalsi;
        }
        Uzol newNode = new Uzol();
        newNode.hodnota = rok;
        aktualny.dalsi = newNode;
    }

    public static void main(String[] args) {
        Vespa v = new Vespa();
        v.pridajNaZaciatok(1980);
        v.pridajNaZaciatok(1980);
        v.pridajNaZaciatok(1976);
        v.pridajNaZaciatok(1975);
        v.pridajNaZaciatok(1969);
        v.pridajNaZaciatok(1951);
        v.pridajNaZaciatok(1950);

        v.pridajVespu(1976);
        System.out.println(v);
    }
}

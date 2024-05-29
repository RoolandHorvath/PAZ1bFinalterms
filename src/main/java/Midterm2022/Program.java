package Midterm2022;

public class Program {
    private static class Vystupenie {
        int dlzka;
        Vystupenie dalsie;
    }
    private Vystupenie prve = null;
    public void pridajNaZaciatok(int hodnota) {
        Vystupenie pridavane = new Vystupenie();
        pridavane.dlzka = hodnota;
        pridavane.dalsie = prve;
        prve = pridavane;
    }
    @Override
    public String toString() {
        String vysledok = "[";
        Vystupenie aktualne = prve;
        while (aktualne != null) {
            if (aktualne != prve)
                vysledok += ", ";
            vysledok += aktualne.dlzka;
            aktualne = aktualne.dalsie;
        }
        return vysledok + "]";
    }
    public void pridajUvedenie(int uvod, int hranica) {

        Vystupenie aktualny = prve;

        while (aktualny != null && aktualny.dalsie != null) {

            if (aktualny.dalsie.dlzka >= hranica) {

                Vystupenie uvodne = new Vystupenie();
                uvodne.dalsie = aktualny.dalsie;
                aktualny.dalsie = uvodne;
                uvodne.dlzka = uvod;
                aktualny = aktualny.dalsie;
            }
            aktualny = aktualny.dalsie;
        }
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.pridajNaZaciatok(80);
        program.pridajNaZaciatok(40);
        program.pridajNaZaciatok(20);
        program.pridajNaZaciatok(40);
        program.pridajNaZaciatok(30);
        System.out.println("Pred: " + program);
        program.pridajUvedenie(5, 40);
        System.out.println("Po: " + program);
    }
}

package Midterm2023;
// 2023
import java.util.*;

public class Uzol {

    private int hmotnost;
    private List<Uzol> deti = new ArrayList<>();

    public Uzol(int hmotnost) {
        this.hmotnost = hmotnost;
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

        System.out.println(hmotnost);
        for (Uzol dieta : deti)
            dieta.vypisRodostrom(level + 1);
    }

    @Override
    public String toString() {
        String result = Integer.toString(hmotnost);
        if (deti.size() != 0) {
            result += "(";
            boolean f = true;
            for (Uzol dieta : deti) {
                if (!f)
                    result += " ";
                result += dieta.toString();
                f = false;
            }
            result += ")";
        }

        return result;
    }

    public int jesen() {

        int output = 0;

        Iterator<Uzol> iterator = deti.iterator();

        while(iterator.hasNext()) {

            Uzol dieta = iterator.next();
            if (dieta.deti.isEmpty()) {
                output += dieta.hmotnost;
                iterator.remove();
            } else {
                output += dieta.jesen();
            }
        }
        return output;
    }

    public static void main(String[] args) {

        Uzol root = new Uzol(10);
        Uzol child1 = new Uzol(5);
        Uzol child2 = new Uzol(8);
        Uzol child3 = new Uzol(1);
        root.pridajDieta(child1);
        root.pridajDieta(child2);
        child1.pridajDieta(child3);

        System.out.println("Rodostrom pred: ");
        root.vypisRodostrom();

        System.out.println("Sum of removed weights: " + root.jesen());

        System.out.println("Rodostrom po: ");
        root.vypisRodostrom();
    }
}
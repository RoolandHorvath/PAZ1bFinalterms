package FinaltermP1_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cesty {

    private List<String> cestyIITriedy = Arrays.asList("1", "2", "8", "22", "23", "111", "222", "223");
    private List<String> results;
    private String input;

    public Cesty(String input) {
        this.input = input;
        this.results = new ArrayList<>();
        generuj(0, new ArrayList<>());
    }

    private void generuj(int odIdx, List<String> currentCombination) {

        if (odIdx == input.length()) {
            results.add(String.join("-", currentCombination));
            return;
        }

        for (String number: cestyIITriedy) {

            if (canStartWith(input,odIdx,number)) {
                currentCombination.add(number);
                generuj(odIdx + number.length(), currentCombination);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }

    private boolean canStartWith(String input, int odIdx, String number) {
        if (odIdx + number.length() > input.length()) return false;
        return input.substring(odIdx, odIdx + number.length()).equals(number);
    }

    private void printResults() {
        for (String result: results) {
            System.out.println(result);
        }
    }
    public static void main(String[] args) {
        String input = "82223";
        Cesty c = new Cesty(input);
        c.printResults();
    }
}
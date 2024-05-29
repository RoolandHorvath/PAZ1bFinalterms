package Midterm2019;

public class NajdiKod {
    private int[] pole;
    private String riesenie = null;
    private String kod;
    private int hashCode;
    private int[] digitArray;

    public NajdiKod(String kod, int hashCode) {
        this.kod = kod;
        this.hashCode = hashCode;
        pole = new int[kod.length()];
        // Initialize the digitArray with the correct size.
        digitArray = new int[kod.length()];
        for (int i = 0; i < kod.length(); i++) {
            // Safely convert character to digit and store it in digitArray.
            digitArray[i] = Character.getNumericValue(kod.charAt(i));
        }
        generuj(0);
        System.out.println(riesenie);
    }

    public void generuj(int odIdx) {
        if (odIdx == pole.length) {
            String candidate = arrayToString(pole);
            if (candidate.hashCode() == hashCode) {
                riesenie = candidate;
                return;
            }
        } else {
            int originalValue = digitArray[odIdx];
            for (int i = -1; i <= 1; i++) {
                int newValue = (originalValue + i + 10) % 10; // Handles cyclic nature of the dials
                pole[odIdx] = newValue;
                generuj(odIdx + 1);
                if (riesenie != null) {
                    return; // Found the solution, exit early.
                }
            }
        }
    }

    // Helper method to convert an array of digits back to a string.
    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int digit : arr) {
            sb.append(digit);
        }
        return sb.toString();
    }

    // Entry point for testing the solution.
    public static void main(String[] args) {
        NajdiKod riesic = new NajdiKod("45564", "55555".hashCode());
        System.out.println(riesic.riesenie); // Print the found solution or null if not found.
    }
}

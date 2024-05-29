package Midterm2018;

public class NajdiSlovo {
    private String slovo;
    private int hashCode;
    private int[] wordLength;
    private String output;
    public NajdiSlovo(String slovo, int hashCode) {
        this.slovo = slovo;
        this.hashCode = hashCode;
        wordLength = new int[slovo.length() - 1];
        generuj(0);
        System.out.println(najdiRiesenie());
    }

    public void generuj(int odIdx) {

        if (odIdx == wordLength.length) {
            spracuj();
            return;
        }

        wordLength[odIdx] = 0;
        generuj(odIdx + 1);
        wordLength[odIdx] = 1;
        generuj(odIdx + 1);
    }
    public String najdiRiesenie() {
        return output;
    }

    public void spracuj() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < slovo.length() - 1; i++) {

            if (wordLength[i] == 0) {
                sb.append(slovo.charAt(i));
            }
            if (wordLength[i] == 1) {
                sb.append(slovo.charAt(i));
                sb.append(" ");
            }
        }
        sb.append(slovo.charAt(slovo.length() - 1));

        if (hashCode == sb.toString().hashCode()) {
            output = sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new NajdiSlovo("jetook", "je to ok".hashCode()));
    }
}
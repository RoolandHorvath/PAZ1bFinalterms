package org.example;

public class TestFibonacchiho {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int vysledok = fibonacci(n - 2) + fibonacci(n - 1);
        return vysledok;
    }
}

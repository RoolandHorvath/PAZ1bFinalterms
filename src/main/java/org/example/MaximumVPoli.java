package org.example;

public class MaximumVPoli {
    public static int maximum(int[] p, int odIdx,
                              int poIdx) {
        if (odIdx == poIdx)
            return p[odIdx];
        else
            return Math.max(p[odIdx],
                    maximum(p, odIdx + 1, poIdx));
    }

    public static int maximumAlt(int[] p, int odIdx, int poIdx) {

        if (p.length == 1) {
            return p[0];
        } else {
            int stred = (odIdx + poIdx) / 2;
            return Math.max(maximumAlt(p, odIdx, stred), maximumAlt(p, stred + 1, poIdx));
        }
    }
}

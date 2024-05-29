package org.example;

import sk.upjs.jpaz2.Turtle;

public class Fraktalka extends Turtle {

    public void trojuholnik(int u, double d) {
        // Základný prípad (báza)
        if (u == 0) {
            return;
        } else {
            // vykreslenie trojuholníka + vnorenie sa o úroveň nižšie a opäťovné vykonanie metódy
            for (int i = 0; i < 3; i++) {
                step(d);
                turn(-60);
                trojuholnik(u - 1, d / 2);
                turn(180);
            }
        }
    }

    double psi = Math.sqrt((Math.sqrt(5)-1)/2);
    public void hexagonAmmann(int u, double d) {

        drawHexagon(d);
    }

    public void drawHexagon(double d) {

        step(d);
        turn(90);
        step(d*(Math.pow(psi, 3)));
        turn(90);
        step(d*(Math.pow(psi, 4)));
        turn(-90);
        step(d*(Math.pow(psi, 5)));
        turn(90);
        step(d*(Math.pow(psi, 2)));
        turn(90);
        step(d*psi);
        turn(90);
    }
}

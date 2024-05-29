package org.example;

import sk.upjs.jpaz2.Turtle;

public class Fraktalka2 extends Turtle {

    public void vlocka(int uroven, double rozmer) {

        if (uroven == 0) {
            return;
        }

        for (int i = 0; i < 6; i++) {

            step(rozmer);
            vlocka(uroven - 1, rozmer / 3);
            step(-rozmer);
            turn(60);
        }
    }

    public void stvorec(int uroven, double rozmer) {

        if (uroven == 0) {
            return;
        }

        for (int i = 0; i < 4; i++) {

            step(rozmer);
            turn(-90);
            stvorec(uroven - 1, rozmer / 4);
            turn(180);
        }
    }

    public void plus(double rozmer) {

        if (rozmer < 1) {
            return;
        }

        for (int i = 0; i < 4; i++) {

            step(rozmer);
            plus(rozmer / 2);
            step(-rozmer);
            turn(90);
        }

    }

    public void sestuholnik(int u, double d) {

        // triviálny prípad
        if (u == 0) return;

        else {
            // rekurzívne kreslenie šesťuholníkov

            for (int i = 0; i < 3; i++) {

                sestuholnik(u - 1, d / 2);

                for (int j = 0; j < 2; j++) {
                    step(d);
                    turn(60);
                }

            }
        }
    }

    public void fraktal(int uroven, double dlzka) {

        if (uroven > 0) {
            for (int i = 0; i <= 4; i++) {
                step(dlzka);
                fraktal(uroven - 1, dlzka / 3);
                turn(90);
            }
        }
    }
}

package org.example;

import sk.upjs.jpaz2.*;

public class Launcher {

    public static void main(String[] args) {


        Fraktalka f = new Fraktalka();
        WinPane wp = new WinPane(500,500);
        wp.add(f);
//        //f.vlocka(5, 50);
//        //f.stvorec(4, 100);
//        //f.plus(100);
//        TestFibonacchiho tf = new TestFibonacchiho();
//      //  System.out.println(fibonacci(5));
//
//        int[] p = new int[10];
//        for(int i = 0; i < p.length; i++) {
//
//            p[i] = (int) (Math.random()*p.length);
//        }
//        MaximumVPoli mvp = new MaximumVPoli();
//        //System.out.println(MaximumVPoli.maximum(p, 0, p.length-1));
//        System.out.println(MaximumVPoli.maximumAlt(p, 0, p.length - 1));
//

        //f.trojuholnik(3, 100);
        PoloveAlgoritmy pa = new PoloveAlgoritmy();
        int[] p = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        //System.out.println(PoloveAlgoritmy.vsetkyRovnake(p, 0, 9));
        f.hexagonAmmann(0, 100);
    }
}
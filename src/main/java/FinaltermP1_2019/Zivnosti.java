package FinaltermP1_2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zivnosti {

    private int n;
    private int m;

    public Zivnosti() {

        File file = new File("C:\\Users\\42190\\IdeaProjects\\paz1bCviko\\src\\main\\java\\FinaltermP1_2019\\file.txt");

        try (Scanner sc = new Scanner(file)) {

            n = sc.nextInt();
            m = sc.nextInt();
            sc.nextLine();



        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        Zivnosti z = new Zivnosti();
    }
}

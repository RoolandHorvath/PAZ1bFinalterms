package Midterm2023;
// 2023
import java.util.*;

public class Poklad {

    public List<String> cesty(int k, int x, int y) {
        List<String> output = new ArrayList<>();
        generate(output, "", 0, 0, x, y, k);
        return output;
    }

    public void generate(List<String> paths, String currentPath, int currentX, int currentY, int targetX, int targetY, int steps) {

        if (steps == 0) {
            if (currentX == targetX && currentY == targetY) {
                paths.add(currentPath);
            }
            return;
        }

        generate(paths, currentPath + "N", currentX, currentY + 1, targetX, targetY, steps - 1);
        generate(paths, currentPath + "S", currentX, currentY - 1, targetX, targetY, steps - 1);
        generate(paths, currentPath + "E", currentX + 1, currentY, targetX, targetY, steps - 1);
        generate(paths, currentPath + "W", currentX - 1, currentY, targetX, targetY, steps - 1);
    }

    public static void main(String[] args) {
        Poklad2 poklad = new Poklad2();
        System.out.println(poklad.cesty(3,-1,2));
    }
}
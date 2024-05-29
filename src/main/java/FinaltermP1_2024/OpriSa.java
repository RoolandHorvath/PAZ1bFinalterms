package FinaltermP1_2024;

public class OpriSa {

    private int solve(int[] array) {

        int output = 0;
        int largestNumInArray = Integer.MIN_VALUE;
        int idxOfLargestNumInArray = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] > largestNumInArray) {
                largestNumInArray = array[i];
                idxOfLargestNumInArray = i;
            }
        }
        
        int leftMax = 0;
        int rightMax = 0;
        int lastValid = largestNumInArray;

        for (int i = idxOfLargestNumInArray - 1; i >= 0; i--) {

            if (lastValid > array[i]) {
                leftMax += array[i];
                lastValid = array[i];
            } else {
                break;
            }
        }

        lastValid = largestNumInArray;

        for (int i = idxOfLargestNumInArray + 1; i < array.length; i++) {

            if (lastValid > array[i]) {
                rightMax += array[i];
                lastValid = array[i];
            } else {
                break;
            }
        }

        output = leftMax + largestNumInArray + rightMax;
        return output;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3,5,2,8,7,4,5};
        OpriSa os = new OpriSa();
        System.out.println(os.solve(array));
    }
}
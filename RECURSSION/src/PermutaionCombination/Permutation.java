package PermutaionCombination;

public class Permutation {
    public static void main(String[] args) {
        int[] boxes = { 0, 0, 0, 0 };
        int ci = 1;
        int ti = 2;
        System.out.println(permutation(boxes, ci, ti));

    }

    private static int permutation(int[] boxes, int ci, int ti) {
        if (ci > ti) {
            for (int i : boxes) {
                System.out.print(i);
            }
            System.out.println();
            return 1;
        }

        int count = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) {
                boxes[i] = ci;
                count += permutation(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
        return count;
    }

}

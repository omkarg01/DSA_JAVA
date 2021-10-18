package Arrays;

public class Patterns {
    public static void main(String[] args) {
        // patter1(4, 4);
        patter2(4, 0);
    }

    private static void patter2(int i, int j) {
        if (i == 0) {
            return;
        }

        if (j < i) {
            System.out.print("* ");
            patter2(i, j + 1);
        } else {
            System.out.println();
            patter2(i - 1, 0);
        }
    }

    private static void patter1(int i, int j) {
        if (i == 0) {
            return;
        }

        System.out.print("* ");
        if (j == 1) {
            System.out.println();
            j = i;
            i = i - 1;
        }
        patter1(i, j - 1);
    }

}

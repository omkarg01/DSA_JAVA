package RecursionLVL1;

public class OneToN {
    public static void main(String[] args) {
        concept(5);
    }

    private static void concept(int i) {
        if (i == 0) {
            return;
        }
        System.out.println(i);
        concept(--i);
    }

    private static void print(int i) {
        if (i == 0) {
            return;
        }
        print(i - 1);
        System.out.println(i);
    }
}

package RecursionLVL1;

public class Count0 {
    public static void main(String[] args) {
        System.out.println(count(126001, 0));
    }

    private static int count(int i, int count) {
        if (i == 0) {
            return count;
        }

        if (i % 10 == 0) {
            return count(i / 10, count + 1);
        } else {
            return count(i / 10, count);
        }
    }
}

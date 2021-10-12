package RecursionLVL1;

public class ReverseNum {
    static int sum = 0;

    public static void main(String[] args) {
        // rev(1254);
        // System.out.println(sum);

        System.out.println(rev2(1254, 4));
    }

    private static int rev2(int i, int digit) {
        if (i % 10 == i) {
            return i;
        }

        return i % 10 * (int) (Math.pow(10, digit - 1)) + rev2(i / 10, digit - 1);
    }

    private static void rev(int i) {
        if (i == 0) {
            return;
        }

        sum = sum * 10 + i % 10;
        rev(i / 10);
    }

}

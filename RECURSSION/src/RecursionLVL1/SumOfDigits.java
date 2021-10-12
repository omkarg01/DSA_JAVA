package RecursionLVL1;

public class SumOfDigits {
    public static void main(String[] args) {
        // System.out.println(usingFOR(1394));
        System.out.println(usingRecursion(1394));

    }

    private static int usingRecursion(int i) {
        if (i == 0){
            return 0;
        }

        return i % 10 + usingRecursion(i/10);
    }

    private static int usingWhile(int i) {
        int count = 0;
        while (i != 0) {

            count += i % 10;
            i /= 10;

        }
        return count;
    }


}

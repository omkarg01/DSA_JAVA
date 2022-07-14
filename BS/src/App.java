import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int largestDigit = -1;
        int smallestDigit = Integer.MAX_VALUE;

        while (num != 0) {
            int last = num % 10;
            if (last > largestDigit) {
                largestDigit = last;
            }
            if (last < smallestDigit) {
                smallestDigit = last;
            }
            num /= 10;
        }

        System.out.println(largestDigit - smallestDigit);
        
    }
}

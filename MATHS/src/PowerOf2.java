/**
 * PowerOf2
 */
public class PowerOf2 {

    public static void main(String[] args) {
        int n = 64;
        System.out.println((n & (n - 1)) == 0);
    }
}
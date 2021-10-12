public class SetBits {
    public static void main(String[] args) {
        int n = 116;
        System.out.println(Integer.toBinaryString(n));
        // System.out.println(Integer.toBinaryString(112));
        int count = 0;

        while (n > 0) {
            count++;
            n = n & (n -1);
            System.out.println(n);
            System.out.println(Integer.toBinaryString(n));
        }
        System.out.println(count);
    }
}

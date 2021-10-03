public class SumOfN {
    public static void main(String[] args) {

        System.out.println(sum(5));
    }

    private static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        // System.out.println(n);
        int ans = n + sum(n - 1);
        return ans;
    }
}
 

package PermutaionCombination;

public class Formula {
    public static void main(String[] args) {
        permComb(5, 3);
    }

    private static void permComb(int n, int r) {
        System.out.println("Permutations : " + nPr(n, r));
        System.out.println("Combinations : " + nCr(n, r));
    }

    public static int nCr(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    public static int nPr(int n, int r) {
        return fact(n) / fact(n - r);
    }

    // Returns factorial of n
    public static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
}

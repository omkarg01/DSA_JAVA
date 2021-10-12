package Math;

import java.util.Arrays;

public class Sieve {
    public static void main(String[] args) {
        int n = 40;
        boolean arr[] = new boolean[n + 1];
        seive(n, arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void seive(int n, boolean[] primes) {
        for (int i = 2; i * i <= n; i++) {
            if(!primes[i]){
                for (int j = i*2; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }
        
        for (int i = 2; i <=n ; i++) {
            if(!primes[i]){
                System.out.println(i + " ");
            }
        }
    }
}

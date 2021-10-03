package ArraysPrac.Searching;

public class ArrangingCoins {
    public static void main(String[] args) {
        int coins = 12;
        int ans = arraningCoins2(coins);
        System.out.println(ans);
    }

    private static int arraningCoins2(int n) {
        long low = 0; 
        long high = n;
          
          while (low <= high) {
             long mid = low + (high-low)/2;
              long sum  = mid*(mid+1)/2;
              
              if(sum == n){
                  return (int)mid;
              } else if(sum < n){
                  low = mid+1;
              } else {
                  high = mid-1;
              }
          }
          return (int)high;
    }

    // private static int arraningCoins(int coins) {
    //     int count = 0;
    //     int reducer = 1;
    //     while (coins >= reducer) {
    //         count++;
    //         coins -= reducer;
    //         reducer++;
    //     }
    //     return count;
    // }
}

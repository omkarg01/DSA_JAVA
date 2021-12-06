package Assignments;

public class CountGoodNumbers {
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
    }

    static long mod = 1000000007 ;
    
    public static int countGoodNumbers(long n) {
        if( n == 1 ){   return 5;   }
        
        long odd = n /2 ;
        long even= n -odd ;
        
        return (int) ((power( 5, even ) * power( 4, odd )) %mod ) ;
    }
    public static long power( long x, long y ){
        if( y == 0 ){   return 1;   }
        
        long ans = power( x, y /2 ) ;
        ans *= ans ;
        
        ans %= mod ;
        if( y % 2 != 0 ){   //  if y is odd
            ans *= x ;
        }
        ans %= mod ;
        return ans ;
    }
}

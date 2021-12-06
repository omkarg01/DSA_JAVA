package Assignments;

public class Power {
    public static void main(String[] args) {
        System.err.println(power(2, 4));
    }

    public static long power( long x, long y ){
        if( y == 0 ){   return 1;   }
        
        long ans = power( x, y /2 ) ;
        ans *= ans ;
        
        if( y % 2 != 0 ){   //  if y is odd
            ans *= x ;
        }
        return ans ;
    }
}

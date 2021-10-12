package BasicRecusrion;
public class Fibo {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        int a = fibonacci(5);
        System.out.println(a);
    }

    public static int fibonacci(int n) {
        if (n < 2){
            return n;
        }
       
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
 
public class FirstUpperCase {
    public static void main(String[] args) {
        char n = first("omKar", 0);
        if (n == 0){
            System.out.println("no upper");
            return;
        }
        System.out.println(n);
    }

    public static char first(String str, int i) {
        if (i == str.length()) {
            return 0;
        }
        if (Character.isUpperCase(str.charAt(i)))
            return str.charAt(i);
        return first(str, i + 1);
    }
}

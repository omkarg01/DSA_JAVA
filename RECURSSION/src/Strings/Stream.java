package Strings;

public class Stream {
    public static void main(String[] args) {
        System.out.println(skipAppNotApple("bappcbapplez"));
    }

    private static String removeA(String up, String p) {
        if (up.isEmpty()) {
            return p;
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            return "" + removeA(up.substring(1), p);
        } else {
            return ch + removeA(up.substring(1), p);
        }
    }

    private static String skipApple(String up) {
        if (up.isEmpty()) {
            return "";
        }

        
        if (up.startsWith("apple")) {
            return skipApple(up.substring(5));
        } else {
            return up.charAt(0) + skipApple(up.substring(1));
        }

    }

    private static String skipAppNotApple(String up) {
        if (up.isEmpty()) {
            return "";
        }

        
        if (up.startsWith("app") && !up.startsWith("apple")) {
            return skipAppNotApple(up.substring(3));
        } else {
            return up.charAt(0) + skipAppNotApple(up.substring(1));
        }
    }

    

}

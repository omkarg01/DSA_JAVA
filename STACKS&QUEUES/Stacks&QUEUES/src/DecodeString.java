import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String str = decodeString("2[abc]3[cd]ef");
        System.out.println(str);
        
    }

    public static String decodeString(String s) {
        Stack<Character> stk = new Stack<>();
        Stack<Integer> stkN = new Stack<>();
        int open = 0;
        int close = 0;
        int n = 0;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            boolean isInt = false;
            try {
                n = Integer.parseInt(String.valueOf(c));
                isInt = true;
            } catch (Exception e) {
                isInt = false;
            } finally {
                if (!isInt) {
                    if (c == '[') open++;
                    else if(c == ']') open--;

                    if (c != ']' && c != '[') {
                        stk.push(c);
                    } else if (c == ']') {

                        String temp = "";
                        while (!stk.empty()) {
                            temp = stk.pop() + temp;
                        }

                        while (n > 0) {
                            ans += temp;
                            n = n - 1;
                        }
                        temp = "";
                    } 

                    if (stk.size() > 0 && open == 0){
                        ans += stk.pop();
                    }

                } else {
                    stkN.push(n);
                }
            }

        }
        return ans;
    }
}

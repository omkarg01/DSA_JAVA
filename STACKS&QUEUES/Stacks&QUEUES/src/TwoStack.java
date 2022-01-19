import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TwoStack {

    ArrayList<Integer> arr;
    int stack1ptr = -1;
    int stack2ptr;

    // Initialize TwoStack.
    public TwoStack(int s) {
        // Write your code here
        arr = new ArrayList(s);
        stack2ptr = s;

        for (int i = 0; i < s; i++) {
            arr.add(i, null);
        }
    }

    // Push in stack 1.
    public void push1(int num) {
        // Write your code here
        if (arr.get(stack1ptr + 1) == null) {
            arr.set(++stack1ptr, num);
        }
    }

    // Push in stack 2.
    public void push2(int num) {
        // Write your code here
        if (arr.get(stack2ptr - 1) == null) {
            arr.set(--stack2ptr, num);
        }
    }

    // Pop from stack 1 and return popped element.
    public int pop1() {
        // Write your code here
        if (stack1ptr < 0) {
            return -1;
        }

        
        int removed = arr.get(stack1ptr);
        arr.set(stack1ptr, null);
        stack1ptr--;

        return removed;
    }

    // Pop from stack 2 and return popped element.
    public int pop2() {
        // Write your code here
        if (stack2ptr > (arr.size() - 1)) {
            return -1;
        }
        
        int removed = arr.get(stack2ptr);
        arr.set(stack2ptr, null);
        stack2ptr++;
        
        return removed;
    }

    public void display() {
        System.out.println(arr + ", size : " + arr.size() + ", ptr1 : " + stack1ptr + ", ptr2 : " + stack2ptr);
    }

    public static void main(String[] args) {
        // TwoStack stack = new TwoStack(3);
        // stack.display();
        // stack.push1(2);
        // stack.display();
        // stack.push1(4);
        // stack.display();
        // stack.push1(3);
        // stack.display();
        // stack.push2(5);
        // stack.display();
        // stack.pop2();
        // stack.display();
        // stack.pop1();
        // stack.display();
        // stack.push2(6);
        // stack.display();
        // stack.pop2();
        // stack.display();
        // stack.pop1();
        // stack.display();
        // stack.push2(7);
        // stack.display();

        Stack<Character> stk = new Stack<>();
        stk.push('a');
        stk.push('b');
        stk.push('c');
        String ans = "";
        for (Character character : stk) {
            ans += character;
        }
        System.out.println(ans);


        
       
    }
}
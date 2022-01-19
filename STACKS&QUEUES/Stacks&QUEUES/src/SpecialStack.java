import java.util.Stack;  
public class SpecialStack {
	// Define the data members.
	int min = Integer.MAX_VALUE;
    int size = 0;
    

	/*----------------- Public Functions of SpecialStack -----------------*/
	Stack<Integer> stk = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    
	void push(int data) {
		// Implement the push() function.
        
        stk.push(data);
        size++;
        if (min > data){
            min = data;
            minStack.push(data);
        }
        
	}

	int pop() {
		// Implement the pop() function.
        if (isEmpty()){
            return -1;
        }
        
        int removed = stk.pop();
        System.out.println(removed + " removed");
        size--;
        if (removed == min){
            // System.out.println(minStack.pop());
            minStack.pop();
            min = minStack.peek();
            System.out.println(minStack.peek() + "min after pop");
        }
        return removed;
	}

	int top() {
		// Implement the top() function.
         if (isEmpty()){
            return -1;
        }
        return stk.peek();
	}

	boolean isEmpty() {
		// Implement the isEmpty() function.
        return stk.empty();
	}

	int getMin() {
         if (isEmpty()){
            return -1;
        }
		// Implement the getMin() function.
        System.out.println(min);
        return min;
	}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return stk.toString();
    }

    public static void main(String[] args) {
        SpecialStack stk = new SpecialStack();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.getMin();
        stk.push(5);
        System.out.println(stk);
        stk.getMin();
        stk.pop();
        System.out.println(stk);
        stk.getMin();


        System.out.println(stk);
    }
}

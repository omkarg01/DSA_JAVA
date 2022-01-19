import java.util.ArrayList;

public class StackIncrementOperation {
    public static void main(String[] args) {
        // StackIncrementOperation stk = new StackIncrementOperation(3);
        // stk.push(1);
        // stk.display();
        // stk.push(2);
        // stk.display();
        // stk.push(3);
        // stk.display();
        // stk.increment(5, 100);
        // stk.display();
        // stk.increment(2, 100);
        // stk.display();

    

    }

    

    ArrayList<Integer> arr;
    int i = -1;
    int maxSize;

    private void display() {
        System.out.println(arr);
    }
    
    public StackIncrementOperation(int maxSize) {
        arr = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if (i < maxSize - 1){
            ++i;
            arr.add(i, x);
        }   
    }
    
    public int pop() {
        if (i > -1){
            int removed = arr.get(i);
            --i;
            return removed;
        }
        
        return -1;
    }
    
    public void increment(int k, int val) {
        int sizeOfStack = i + 1;
        if (k > sizeOfStack){
            for (int j = 0; j < sizeOfStack; j++){
                int preVal = arr.get(j);
                arr.set(j, preVal + val);
            }
        } else {
             for (int j = 0; j < k; j++){
                int preVal = arr.get(j);
                arr.set(j, preVal + val);
            }
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */


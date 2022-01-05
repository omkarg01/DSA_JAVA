public class StackMain {
    public static void main(String[] args) throws Exception {
        CustomStack stacks = new CustomStack(3);
        stacks.push(10);
        stacks.push(12);
        stacks.push(15);
        // stacks.push(20);
        // stacks.pop();

        System.out.println(stacks.peek());
    }
}

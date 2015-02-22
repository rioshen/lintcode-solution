public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public Solution() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty() || minStack.peek() >= number) {
            minStack.push(number);
        }
    }

    public int pop() {
        // write your code here
        int number = stack.pop();
        if (number <= minStack.peek()) {
            minStack.pop();
        }
        return number;
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
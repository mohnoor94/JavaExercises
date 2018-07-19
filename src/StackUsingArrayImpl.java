public class StackUsingArrayImpl {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);

        System.out.println("========================");
        stack.push(1000);
        stack.push(2000);
        stack.push(3000);
        stack.push(4000);
        stack.push(5000);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println("========================");
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println("========================");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println("========================");
        stack.push(10000);
        System.out.println(stack.pop());
    }

    static class ArrayStack {

        private final int[] stack;
        private int top = 0;
        private int size = 0;

        ArrayStack(int size) {
            stack = new int[size];
        }

        boolean isEmpty() {
            return size == 0;
        }

        boolean isFull() {
            return size == stack.length;
        }

        void push(int element) {
            if (isFull()) {
                throw new RuntimeException("Stack is full");
            }

            stack[top++] = element;
            size++;
        }

        int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }

            size--;
            return stack[--top];
        }

        int top() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return stack[top - 1];
        }
    }
}
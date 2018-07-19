public class QueueUsingTwoStacksImpl {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
//        System.out.println(q.peek());
        q.enqueue(10);
        System.out.println(q.peek());
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(5);
        q.enqueue(0);
        System.out.println(q.peek());

        System.out.println("=============");

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
    }

    static class MyQueue {

        StackUsingNodeImpl.MyStack newItemsStack = new StackUsingNodeImpl.MyStack();
        StackUsingNodeImpl.MyStack oldItemsStack = new StackUsingNodeImpl.MyStack();

        void enqueue(int value) {
            newItemsStack.push(value);
        }

        int peek() {
            if (oldItemsStack.isEmpty()) shiftStacks();
            return oldItemsStack.peek();
        }

        int dequeue() {
            if (oldItemsStack.isEmpty()) shiftStacks();
            return oldItemsStack.pop();
        }

        private void shiftStacks() {
            while (!newItemsStack.isEmpty()) oldItemsStack.push(newItemsStack.pop());
        }
    }
}

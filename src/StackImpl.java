
public class StackImpl {
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
}

class ArrayStack {
	private final int[] stack;
	private int top = 0;
	private int size = 0;

	public ArrayStack(int size) {
		stack = new int[size];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == stack.length;
	}

	public void push(int element) {
		if (isFull()) {
			throw new RuntimeException("Stack is full");
		}

		stack[top++] = element;
		size++;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}

		size--;
		return stack[--top];
	}

	public int top() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return stack[top - 1];
	}
}
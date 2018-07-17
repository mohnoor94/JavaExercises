
public class QueueImpl {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(10);

		queue.add(10);
		queue.add(20);
		queue.add(30);
		System.out.println(queue.peek());
		queue.add(40);
		queue.add(50);
		queue.add(60);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		queue.add(70);
		queue.add(80);
		queue.add(90);
		System.out.println(queue.peek());
		queue.add(200);
		queue.add(300);
		queue.add(400);
		queue.add(500);
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		queue.add(600);

		System.out.println(queue.isExists(10));
		System.out.println(queue.isExists(20));
		System.out.println(queue.isExists(30));
		System.out.println(queue.isExists(40));
		System.out.println(queue.isExists(50));
		System.out.println(queue.isExists(60));
		System.out.println(queue.isExists(70));
		System.out.println(queue.isExists(80));
		System.out.println(queue.isExists(90));
		System.out.println(queue.isExists(100));
		
		System.out.println("=====================");
		
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		System.out.println(queue.remove());
		
	}
}

class ArrayQueue {
	private final int[] queue;
	private int first;
	private int last;
	private int size = 0;

	public ArrayQueue(int size) {
		queue = new int[size];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == queue.length;
	}

	public void add(int element) { // addLast
		if (isFull()) {
			throw new RuntimeException("Queue is full");
		}

		queue[last] = element;
		size++;
		last = (last + 1) % queue.length;
	}

	public int remove() { // removeFirst
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}

		int element = queue[first];
		first = (first + 1) % queue.length;
		size--;
		return element;
	}

	public int peek() { // getFirst
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return queue[first];
	}

	public boolean isExists(int element) {
		if (first < last)
			return isExists(element, first, last);
		else
			return isExists(element, first, size - 1) || isExists(element, 0, last);
	}

	private boolean isExists(int element, int start, int end) {
		for (int i = start; i <= end; i++)
			if (queue[i] == element)
				return true;
		return false;
	}
}
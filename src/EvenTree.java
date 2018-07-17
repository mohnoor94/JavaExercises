/**
 * Not completed
 */
public class EvenTree {

	public static void main(String[] args) {
		int treeNodes = 10;
		int treeEdges = 9;
		int[] treeFrom = new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] treeTo = new int[] { 1, 1, 3, 2, 1, 2, 6, 8, 8 };

		// for (int i = 0; i < treeFrom.length; i++) {
		// System.out.println(treeFrom[i] + " " + treeTo[i]);
		// }

		Queue[] adjLists = new Queue[treeNodes];
		for (int i = 0; i < treeNodes; i++) {
			adjLists[i] = new Queue(treeEdges);
		}

		for (int i = 0; i < treeFrom.length; i++) {
			adjLists[treeFrom[i] - 1].add(treeTo[i] - 1);
			adjLists[treeTo[i] - 1].add(treeFrom[i] - 1);
		}

		for (int i = 0; i < treeNodes; i++) {
			System.out.print(i + 1 + " ==> ");
			while (!adjLists[i].isEmpty()) {
				System.out.print(adjLists[i].remove() + 1 + " ");
			}
			System.out.println();
		}

	}

	static class Queue {
		private final int[] queue;
		private int first;
		private int last;
		private int size = 0;

		public Queue(int size) {
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
	}
}

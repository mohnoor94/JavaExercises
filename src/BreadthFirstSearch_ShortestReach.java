/**
 * Problem Statement: https://www.hackerrank.com/challenges/bfsshortreach
 */
@SuppressWarnings({"SameParameterValue", "Duplicates"})
public class BreadthFirstSearch_ShortestReach {

    // Complete the bfs function below.
    private static int[] bfs(int n, int[][] edges, int source) {
        boolean[][] adjacencyMatrix = getAdjacencyMatrix(n, edges);
        boolean[] visited = new boolean[n]; // all false
        int[] distances = new int[n]; // all zeros
        for (int i = 0; i < distances.length; i++) {
            distances[i] = -1;
        }
        distances[source - 1] = 0;
        Queue queue = new Queue(n);
        queue.add(source - 1);
        visited[source - 1] = true;

        while (!queue.isEmpty()) {
            int me = queue.remove();
            for (int i = 0; i < n; i++) {
                if (i != me && !visited[i] && adjacencyMatrix[me][i]) { // getNeighbors
                    visited[i] = true;
                    distances[i] = distances[me] + 6;
                    queue.add(i);
                }
            }
        }

        int[] distancesWithoutSource = new int[n - 1];
        for (int i = 0; i < source - 1; i++)
            distancesWithoutSource[i] = distances[i];
        for (int i = source; i < n; i++)
            distancesWithoutSource[i - 1] = distances[i];

        return distancesWithoutSource;
    }

    private static boolean[][] getAdjacencyMatrix(int n, int[][] edges) {
        boolean[][] matrix = new boolean[n][n];
        for (int[] edge : edges) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            matrix[x][y] = true;
            matrix[y][x] = true;
        }
        return matrix;
    }

    @SuppressWarnings("Duplicates")
    static class Queue {
        private final int[] queue;
        private int first;
        private int last;
        private int size = 0;

        Queue(int size) {
            queue = new int[size];
        }

        boolean isEmpty() {
            return size == 0;
        }

        boolean isFull() {
            return size == queue.length;
        }

        void add(int element) { // addLast
            if (isFull()) {
                throw new RuntimeException("Queue is full");
            }

            queue[last] = element;
            size++;
            last = (last + 1) % queue.length;
        }

        int remove() { // removeFirst
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }

            int element = queue[first];
            first = (first + 1) % queue.length;
            size--;
            return element;
        }
    }

    public static void main(String[] args) {
        int[] result = bfs(4, new int[][]{{1, 2}, {1, 3}}, 1);
        for (int aResult : result) System.out.print(aResult + " ");
    }
}
import java.util.LinkedList;

/**
 * Problem Statement: https://www.hackerrank.com/challenges/bfsshortreach
 */
@SuppressWarnings({"SameParameterValue", "Duplicates"})
public class BreadthFirstSearch_ShortestReach_2 {

    // Complete the bfs function below.
    private static int[] bfs(int n, int[][] edges, int source) {
        boolean[][] adjacencyMatrix = getAdjacencyMatrix(n, edges);
        int[] distances = new int[n]; // all zeros
        for (int i = 0; i < distances.length; i++) {
            distances[i] = -1;
        }
        distances[source - 1] = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source - 1);

        while (!queue.isEmpty()) {
            int me = queue.remove();
            for (int i = 0; i < n; i++) {
                if (i != me && distances[i] != 0 && adjacencyMatrix[me][i]) { // getNeighbors
                    distances[i] = distances[me] + 6;
                    queue.add(i);
                }
            }
        }

        int[] distancesWithoutSource = new int[n - 1];
        System.arraycopy(distances, 0, distancesWithoutSource, 0, source - 1);
        System.arraycopy(distances, source, distancesWithoutSource, source - 1, n - source);

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


    public static void main(String[] args) {
        int[] result = bfs(4, new int[][]{{1, 2}, {1, 3}}, 1);
        for (int aResult : result) System.out.print(aResult + " ");
    }
}
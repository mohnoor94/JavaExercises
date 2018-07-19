public class Search {
    public static void main(String[] args) {
        int[] array = initializeArray();
        System.out.println("Linear Search");
        System.out.println(linearSearch(array, 950));
        System.out.println(linearSearch(array, 7650));
        System.out.println(linearSearch(array, 2));
        System.out.println(linearSearch(array, -20));
        System.out.println("=======================");

        array = initializeArray();
        System.out.println("Binary Search");
        System.out.println(binarySearch(array, 950));
        System.out.println(binarySearch(array, 7650));
        System.out.println(binarySearch(array, 2));
        System.out.println(binarySearch(array, -20));
        System.out.println("=======================");
    }

    private static boolean binarySearch(int[] array, int goal) {
        Sort.mergeSort(array);
        return binarySearch(array, goal, 0, array.length - 1);
    }

    /**
     * Speed O(log n)
     * Space O(log n) recursion call stack space
     */
    private static boolean binarySearch(int[] array, int goal, int start, int end) {
        int mid = (start + end) / 2;
        if (goal == array[mid]) return true;
        if (start == end) return false;
        if (goal < array[mid]) return binarySearch(array, goal, start, mid - 1);
        if (goal > array[mid]) return binarySearch(array, goal, mid + 1, end);
        return false;
    }

    /**
     * Speed O(n)
     */
    private static boolean linearSearch(int[] array, int goal) {
        for (int i : array) if (goal == i) return true;
        return false;
    }

    private static int[] initializeArray() {
        return new int[]{-5, 5, 4, 2, 0, -7, 5, 4, 33, 950, -740, 630, 142, 20, -451, 0, 0, 675, -72};
    }
}

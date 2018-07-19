import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] array = initializeArray();
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

        array = initializeArray();
        mergeSort(array);
        System.out.println(Arrays.toString(array));

        array = initializeArray();
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * TODO: Implement me!
     * Speed --> O(n log(n))
     * Space --> 0 [can be done in place]
     *
     * Not good if the pivot are one of extremes
     * --> worst case O(n^2)
     */
    private static void quickSort(int[] array) {
        throw new NotImplementedException();
    }


    /**
     * Speed --> O(n log(n))
     * Space --> O(n)
     */
    public static void mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] workplace, int from, int to) {
        if (from >= to) return;
        int mid = (from + to) / 2;
        mergeSort(array, workplace, from, mid);
        mergeSort(array, workplace, mid + 1, to);
        mergeHalves(array, workplace, from, to);
    }

    private static void mergeHalves(int[] array, int[] workplace, int leftHalfStart, int rightHalfEnd) {
        int leftHalfEnd = (leftHalfStart + rightHalfEnd) / 2;
        int rightHalfStart = leftHalfEnd + 1;
        int size = rightHalfEnd - leftHalfStart + 1;

        int leftPointer = leftHalfStart;
        int rightPointer = rightHalfStart;
        int mainPointer = leftHalfStart;

        while (leftPointer <= leftHalfEnd && rightPointer <= rightHalfEnd) {
            if (array[leftPointer] < array[rightPointer]) {
                workplace[mainPointer] = array[leftPointer];
                leftPointer++;
            } else {
                workplace[mainPointer] = array[rightPointer];
                rightPointer++;
            }
            mainPointer++;
        }

        System.arraycopy(array, leftPointer, workplace, mainPointer, leftHalfEnd - leftPointer + 1);
        System.arraycopy(array, rightPointer, workplace, mainPointer, rightHalfEnd - rightPointer + 1);
        System.arraycopy(workplace, leftHalfStart, array, leftHalfStart, size);
    }


    /**
     * Speed --> O(n^2)
     * Space --> 0 [in place]
     */
    private static void bubbleSort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false;
                }
            }
            lastUnsorted--;
        }
    }

    private static void swap(int[] array, int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    private static int[] initializeArray() {
        return new int[]{-5, 5, 4, 2, 0, -7, 5, 4, 33, 950, -740, 630, 142, 20, -451, 0, 0, 675, -72};
    }
}

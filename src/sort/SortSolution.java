package sort;

/**
 * Created by lafengnan on 16/10/8.
 */
public class SortSolution {

    public static void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;
            while (j >= 0 && key < data[j])  {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
    }

    public static void selectionSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = data.length - 1;
            int min = data[minIndex];
            for (int j = i; j < data.length - 1; j++) {
                if (min > data[j]) {
                    minIndex = j;
                    min = data[j];
                }
            }

            int tmp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = tmp;
        }
    }

    public static void mergeSort(int[] data, int low, int high) {
        if (low < high) {
            int mid = (low + high) >> 1;
            mergeSort(data, low, mid);
            mergeSort(data, mid + 1, high);
            merge(data, low, mid, high);
        }
    }

    private static void merge(int[] data, int low, int mid, int high) {
        int n1 = mid - low + 1, n2 = high - mid;
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        for (int i = 0; i < n1; i++) left[i] = data[low + i];
        for (int i = 0; i < n2; i++) right[i] = data[mid + i + 1];
        left[n1] = right[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0, k = low;
        while (k <= high) data[k++] = left[i] <= right[j]?left[i++]:right[j++];
    }
}


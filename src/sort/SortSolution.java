package sort;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by lafengnan on 16/10/8.
 */
public class SortSolution {

    /**
     * Following sort algorithms are implementation of O(n)
     */

    public static int[] countSort(int[] data, int max) {
        int[] out = new int[data.length];
        int[] marks = new int[max + 1];

        // init marks to 0
        for (int i = 0; i < max + 1; i++) marks[i] = 0;

        // set marks[k] to the number of data that equals to k
        for (int d : data) marks[d] = marks[d] + 1;

        // set marks[k] to the number of data that less than or equal to k
        for (int j = 0; j < marks.length - 1; j++) marks[j+1] += marks[j];

        // set data[j] to the position where data[j] greater than or equal to data[j]
        // by using marks array that has contained all the marks
        for (int k = data.length - 1; k >= 0; k--) {
            out[marks[data[k]] - 1] = data[k];
            marks[data[k]] -= 1;
        }

        return out;
    }

    @SuppressWarnings("unchecked")
    public static void bucketSort(int[] data, int max) {
        int factor = max / data.length;
        List[] sortedListArray = new List[data.length];

        for (int aData : data) {
            int idx = aData / factor;
            idx = idx >= data.length ? data.length - 1 : idx;
            if (sortedListArray[idx] == null) {
                sortedListArray[idx] = new LinkedList<Integer>();
                sortedListArray[idx].add(aData);
            } else {
                int j = sortedListArray[idx].size() - 1;
                for (; j >= 0; j--) {
                    if ((Integer) sortedListArray[idx].get(j) <= aData) break;
                }

                sortedListArray[idx].add(j + 1, aData);
            }
        }

        int i = 0;
        for (int k = 0; k < data.length; k++) {
            if (sortedListArray[k] != null) {
                for (Object d : sortedListArray[k]) {
                    data[i++] = (Integer)d;
                }
            }
        }
    }

    public static int[] fakeBucketSort(int[] data, int max) {
        int[] bucket = new int[max + 1];
        List<Integer> sortedList = new LinkedList<>();

        for (int i = 0; i < data.length; i++) {
            bucket[data[i]] = data[i];
        }

        for (int a : bucket) {
            if (a != 0) sortedList.add(a);
        }
        int[] sorted = new int[sortedList.size()];
        for (int i = 0; i < sorted.length; i++) sorted[i] = sortedList.get(i);
        return sorted;
    }

    /**
     * Following sort implementations are O(nlgn)
     * @param data
     */

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

    public static void quickSort(int[] data, int l, int h) {
        if (l < h) {
            int x = partition(data, l, h);
            quickSort(data, l, x - 1);
            quickSort(data, x + 1, h);
        }
    }

    private static int partition(int[] data, int l, int h) {
        int x = data[h];
        int i = l - 1;
        for (int j = l; j <= h - 1; j++) {
            if (data[j] <= x) {
                i++;
                if (i != j) {
                    data[i] ^= data[j];
                    data[j] ^= data[i];
                    data[i] ^= data[j];
                }
            }
        }
        int tmp = data[i+1];
        data[i+1] = data[h];
        data[h] = tmp;
        return i + 1;
    }
}


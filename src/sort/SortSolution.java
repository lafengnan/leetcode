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
}

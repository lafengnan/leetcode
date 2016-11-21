package sort;

/**
 * Created by lafengnan on 16/10/8.
 */
public class TestSortSolution {
    private int[] data = {5, 2, 1, 6, 0, 7, 20, 10, 8, -1, 2, 5};

    public void display(int[] cloned) {
        for (int d : cloned) {
            System.out.println(d);
        }
    }

    public void testInsertSort() {
        int[] cloned = data.clone();
        display(cloned);
        SortSolution.insertSort(cloned);
        System.out.println("--------");
        display(cloned);
        System.out.println("========");
    }

    public void testSelectionSort() {
        int[] cloned = data.clone();
        display(cloned);
        SortSolution.selectionSort(cloned);
        System.out.println("--------");
        display(cloned);
        System.out.println("========");
    }

    public void testMergeSort() {
        int[] cloned = data.clone();
        display(cloned);
        SortSolution.mergeSort(cloned, 0, cloned.length - 1);
        System.out.println("--------");
        display(cloned);
        System.out.println("========");
    }

    public void testQuickSort() {
        int[] cloned = data.clone();
        display(cloned);
        SortSolution.quickSort(cloned, 0, cloned.length - 1);
        System.out.println("--------");
        display(cloned);
        System.out.println("========");
    }

    public void testBucketSort() {
        int[] cloned = {3, 2, 7, -1, -4, 18, 5, 9, 20, 1, 19};
        display(cloned);
//        cloned = SortSolution.fakeBucketSort(cloned, 20);
        SortSolution.bucketSort(cloned, 20);
        System.out.println("--------");
        display(cloned);
        System.out.println("========");
    }

    public void testCountSort() {
        int[] data = {2, 3, 0, 1, 5, 7, 0, 2, 5};
        display(data);
        System.out.println("--------");
        display(SortSolution.countSort(data, 7));
        System.out.println("========");
    }

    public static void main(String... args) {
        TestSortSolution solution = new TestSortSolution();
//        solution.testInsertSort();
//        solution.testSelectionSort();
//        solution.testMergeSort();
//        solution.testQuickSort();
//        solution.testBucketSort();
        solution.testCountSort();
    }
}

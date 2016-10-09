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

    public static void main(String... args) {
        TestSortSolution solution = new TestSortSolution();
        solution.testInsertSort();
        solution.testSelectionSort();
    }
}

package array;


/**
 * Created by lafengnan on 16/9/11.
 */
public class TestArraySolution {
    private ArraySolution solution = new ArraySolution();

    public void testTwoSum() {
        try {
            int[] indices = solution.twoSum(new int[]{2,7,11,15}, 9);
            System.out.println("[" + indices[0] + ", " + indices[1] + "]");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void testRemoveElement() {
        int[] data = new int[] {1, 1, 2, 2, 3, 4};
        System.out.println(solution.removeElement(data, 2));
    }

    public void testRemoveDuplicatesFromSortedArray() {
        int[] data = new int[] {1, 1, 2, 2, 3};
        System.out.println(solution.removeDuplicatesFromSortedArray(data));
    }

    public void testRemoveDuplicatesFromSortedArrayN() {
        int[] data = new int[] {1, 1, 1, 2, 3};
        System.out.println(solution.removeDuplicatesFromSortedArrayN(data, 2));
    }

    public void testSearchInRotatedSortedArray() {
        int[] data = new int[] {0,1,2,3,4,5,6,7};
        System.out.println(solution.searchInRotatedSortedArray(data, 4));
        data = new int[] {4,5,6,7,0,1,2};
        System.out.println(solution.searchInRotatedSortedArray(data, 0));
        System.out.println(solution.searchInRotatedSortedArray(data, 1));
    }

    public static void main(String... args) {
        TestArraySolution test = new TestArraySolution();
        test.testTwoSum();
        test.testRemoveElement();
        test.testRemoveDuplicatesFromSortedArray();
        test.testRemoveDuplicatesFromSortedArrayN();
        test.testSearchInRotatedSortedArray();
    }
}

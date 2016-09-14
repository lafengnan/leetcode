package single_linked_list;

import utils.SingleLinkedList;

/**
 * Created by lafengnan on 16/9/11.
 */
public class TestSingleLinkedListSolution {
    private SingleLinkedListSolution solution = new SingleLinkedListSolution();

    public void testAddTwoNumbers() {
        SingleLinkedList<Integer> l1 = new SingleLinkedList<>();
        SingleLinkedList<Integer> l2 = new SingleLinkedList<>();
        l1.insertHead(3);
        l1.insertHead(4);
        l1.insertHead(2);
        l2.insertHead(4);
        l2.insertHead(6);
        l2.insertHead(5);
        solution.addTwoNumbersV1(l1, l2).display();
        solution.addTwoNumbersV2(l1, l2);
    }

    public static void main(String... args) {
        TestSingleLinkedListSolution test = new TestSingleLinkedListSolution();
        test.testAddTwoNumbers();
    }
}

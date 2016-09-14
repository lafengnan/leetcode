package single_linked_list;

import utils.SingleLinkedList;

/**
 * Created by lafengnan on 16/9/11.
 */

public class SingleLinkedListSolution {

    public SingleLinkedList<Integer> addTwoNumbersV1(final SingleLinkedList<Integer> l1,
                                                     final SingleLinkedList<Integer> l2) {
        SingleLinkedList<Integer> result = new SingleLinkedList<>();

        int i = 0, carry = 0;
        while ( i < Math.max(l1.size(), l2.size())) {
            int x = l1.getValue(i) == null?0:l1.getValue(i);
            int y = l2.getValue(i) == null?0:l2.getValue(i);
            int sum = x + y + carry;
            carry = sum/10;
            result.insertTail(sum % 10);
            i++;
        }
        if (carry > 0) {
            result.insertTail(carry);
        }

        return result;
    }

    public void addTwoNumbersV2(SingleLinkedList<Integer> l1, SingleLinkedList<Integer> l2) {
        int v1 = 0, v2 = 0;
        SingleLinkedList<Integer> result = new SingleLinkedList<>();

        for (int i = 0; i < l1.size(); i++) {
            v1 += l1.getValue(i) * Math.pow(10, i);
        }
        for (int i = 0; i < l2.size(); i++) {
            v2 += l2.getValue(i) * Math.pow(10, i);
        }

        String s = String.valueOf(v1 + v2);
        for (char c : s.toCharArray()) {
            result.insertHead(Integer.valueOf(String.valueOf(c)));
        }
        result.display();
    }
}

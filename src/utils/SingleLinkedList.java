package utils;

/**
 * Created by lafengnan on 16/9/11.
 * The single linked list consists of head node, tail node
 * and node length data. Tail node always points to the last
 * node of list
 *  ==========
 * |   len    |
 *  ==========       =======          =======
 * |   head   | --> | value |    .-->| value |
 *  ==========       -------     |    -------
 * |   tail  |  --. | next  | ---    | next  | --> null
 *  =========     |  =======          =======
 *                |                      ^
 *                |______________________|
 */
public class SingleLinkedList<T> {
    private int len;
    private Node head;
    private Node tail;

    public SingleLinkedList() {
        len = 0;
        head = tail = null;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public synchronized int size() {
        return len;
    }

    /**
     * Insert a new node(nodeX) with value from head(node0).
     * head(node0)->node1->node2->null will change to
     * head(nodeX)->node0->node1->node2->null
     *
     * @param v The value to insert into single linked list
     * @return The length of list after insertion
     */
    public synchronized int insertHead(T v) {
        Node node = new Node(v);
        if (head == null) {
            tail = head = node;
        } else {
            node.next = head;
            head = node;
        }
        return ++len;
    }

    /**
     * Insert a new node(nodeX) with value to the tail
     * head->node1->node2->null
     * tail----------^            will change to
     * head->node1->node2->nodeX->null
     * tail-----------------^
     *
     * @param v The value to insert into single linked list
     * @return The length of list after insertion
     */
    public synchronized int insertTail(T v) {
        Node node = new Node(v);
        if (head == null) {
            tail = head = node;
        } else {
            tail.next = node;
            tail = node;
        }
        return ++len;
    }

    /**
     * Insert a new node(nodeX) with value after to the given position.
     * head->node0-->node1-->node2>null
     * tail--------------------^
     *
     * head->node0-->node1-->nodeX-->node2-->null
     * tail----------------------------^
     * @param position The index of node in list
     * @return The length of list after insertion
     */
    public synchronized int insertAfterPosition(final int position, T v){
        if (position < 0) {
            return -1;
        }
        if (position >= len) {
            return insertTail(v);
        }

        Node p = head;
        int index = position;
        while (index-- > 0) {
            p = p.next;
        }

        Node node = new Node(v);
        node.next = p.next;
        p.next = node;

        return len++;
    }

    /**
     * Reverse the list by traveling the list
     */
    public synchronized void reverse() {
        if (len == 1) return;

        Node p = head, q = p.next;
        while (q != null) {
            Node x = q.next;
            q.next = p;
            p = q;
            q = x;
        }
        head.next = null;
        Node tmp = head;
        head = tail;
        tail = tmp;
    }

    /**
     * Reverse one linked list by using recursive solution.
     * @param head Current head node of sub-list
     * @return The reversed list's head node
     */
    public synchronized Node reverseRecursively(Node head) {
        if (head == null || head.next == null) {
            this.head = head;
            return head;
        }

        Node newHead = reverseRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     * For example: Given 1->2->3->4->5->nullptr, m = 2 and n = 4,
     * return 1->4->3->2->5->null.
     * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
     * @param begin The left edge of node to reverse
     * @param end The right edge of node to reverse
     */
    public synchronized void reverseWithRange(final int begin, final int end) {

        assert 1 <= begin && begin <= end && end <= len;
        Node dummy = head, p = head;
        Node q = p.next, x = null;

        if (q == null || begin == end) {
            return;
        }

        for (int i = 1; i < end; i++) {
            if (i < begin) {
                dummy = p;
                p = p.next;
                q = p.next;
                continue;
            }

            if (q != null) {
                x = q.next;
                q.next = p;
            }
            p = q;
            q = x;
        }

        if (begin > 1) {
            dummy.next.next = q;
            dummy.next = p;
        } else {
            head = p;
            dummy.next = q;
        }
    }


    /**
     * Return the value of node at given position
     * @param position The node's position in list
     * @return The value of given position's node
     */
    public T getValue(int position) {
        position = position < len?position:len;
        Node node = head;
        for (; position > 0; position--) {
            node = node.next;
        }
        return node == null?null:node.value;
    }

    public void display() {
        if (len > 0) {
            String info = "";
            Node node = head;
            while (node != null) {
                info += node.value + "->";
                node = node.next;
            }
            info = info.substring(0, info.length() - 2);
            System.out.println(info);
        }
    }

    /**
     * Presentation of one node structure in a single linked
     * list. The node is not visible out of list and it should
     * be initialized while inserting node to list.
     */
    private class Node {
        T value;
        Node next;

        Node(T v) {
            value = v;
            next = null;
        }
    }
}

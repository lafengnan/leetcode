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

    public int size() {
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

    public T getValue(int i) {
        i = i < len?i:len;
        Node node = head;
        for (; i > 0; i--) {
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

    private class Node {
        T value;
        Node next;

        Node(T v) {
            value = v;
            next = null;
        }
    }
}

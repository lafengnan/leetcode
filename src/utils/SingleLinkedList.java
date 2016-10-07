package utils;

import sun.jvm.hotspot.utilities.Assert;

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
     * Swap the two nodes in positions of left and right.
     * Swapping is implemented by change the value of them, not
     * swapping the nodes directly.
     * @param left The left node to swap
     * @param right THe right node to swap with left
     */
    public synchronized void swap(final int left, final int right) {
        Assert.that(left <= right && right <= len, "expect condition: size >= right >= left");

        Node p = head, q = head;
        for (int i = 1; i < right; i++) {
            if (i < left) {
                p = p.next;
            }
            q = q.next;
        }

        T tmp = p.value;
        p.value = q.value;
        q.value = tmp;
    }

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     * For example,
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     *
     * Your algorithm should use only constant space. You may not modify the
     * values in the list, only nodes itself can be changed.
     * @return The head of swapped single linked list
     */
    public synchronized Node swapInPairs() {
        Node p = head;
        Node q = head;
        if (size() < 3) {
            if (size() == 2) {
                head = p.next;
                p.next.next = p;
                p.next = null;
            }
            return head;
        }

        // swapping
        head = p.next;
        while (p.next != null) {
            q = p.next.next;
            p.next.next = p;
            if (q == null) {
                p.next = null;
                break;
            } else {
                if (q.next == null) {
                    p.next = q;
                } else {
                    p.next = q.next;
                }
            }
            p = q;
        }

        return head;
    }

    /**
     * Given a linked list, remove the nth node from the end of list and return its head.
     * For example, Given linked list: 1->2->3->4->5, and n = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5. Note:
     * 1. Given n will always be valid.
     * 2. Try to do this in one pass.
     * @param index The given index of node to remove from tail
     */
    public synchronized void removeNthNodeFromTail(final int index) {
        Node p = head;
        int distance = len - index;

        if (distance <= 0) { // remove the first node
            head = p.next;
            p.next = null;
            len--;
            return;
        } else {
            while (--distance > 0) {
                p = p.next;
            }
        }

        // last node to remove
        if (p.next.next == null) {
            p.next = null;
            tail = p;
        } else {
            Node tmp = p.next;
            p.next = p.next.next;
            tmp.next = null;
        }
        len--;
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
     * Given a linked list and a value x, partition it such that all nodes less than x
     * come before nodes greater than or equal to x. You should preserve the original
     * relative order of the nodes in each of the two partitions.
     * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
     * @param x The partition value to split list
     */
    public synchronized void partition(T x) {
        Node p = head;
        Node nodeX = new Node(x);

        // travel to the first node with value of x (node[X])
        // head->node[2]->node[3]->...node[k]->node[X]->node[m]->node[n]->...
        // dummy will point to node[k] and p point to node[X]
        while (p != null && p.value != x) {
            p = p.next;
        }

        Node q = p == null?null:p.next;
        if (p == head) {
            Node dummy = q;
            while (q != null) {
                if (q.compareTo(nodeX) > 0) {
                    dummy = q;
                    q = q.next;
                    continue;
                }
                dummy.next = q.next;
                q.next = p;
                head = q;
                q = dummy.next;
            }
        } else {
            while (q != null) {
                if (q.compareTo(nodeX) > 0) {
                    p = q;
                    q = q.next;
                    continue;
                }

                Node prev = null;
                Node cur = head;
                while (q.compareTo(cur) > 0) {
                    prev = cur;
                    cur = cur.next;
                }
                // move q from origin after to cur
                p.next = q.next;
                prev.next = q;
                q.next = cur;
                q = p.next;
            }
        }
    }

    /**
     * A linked list is given such that each node contains an additional
     * random pointer which could point to any node in the list or null.
     * Return a deep copy of the list.
     * @return The head of deep copied list
     */
    public synchronized Node slowDeepCopyRandomNodeList() {
        Node dummy = new Node();
        dummy.next = null;
        dummy.random = null;

        Node p = head, q = head, d = dummy;
        while (p != null) {
            Node node = new Node(p.value);
            node.next = null;
            node.random = p.random;
            d.next = node;
            d = node;

            q = p;
            p = p.next;
        }

        d = dummy.next;
        q = dummy.next;
        while (d != null) {
            Node rdNode = d.random;
            if (rdNode != null) {
                p = head;
                int pos = 0;
                while (p != rdNode) {
                    pos++;
                    p = p.next;
                }
                for (int i = 0; i < pos; i++) {
                    q = q.next;
                }
                d.random = q;
                q = dummy.next;
            }
            d = d.next;
        }
        return dummy.next;
    }

    /**
     * A linked list is given such that each node contains an additional
     * random pointer which could point to any node in the list or null.
     * This method implements by chaining two linked list and then get the random
     * pointer, then detach two linked list into two lists.
     * Return a deep copy of the list.
     * @return The head of deep copied list
     */
    public synchronized Node deepCopyRandomNodeList() {
        if (head == null) return null;

        Node p = head;

        // step 1 refactor src list and chain with new created nodes
        while (p != null) {
            Node node = new Node(p.value);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }

        // step 2 finding randoms and refactor randoms of new created nodes
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // step 3 detach the cloned list from src list and refactor src to its original state
        p = head;
        Node dummy = new Node();
        Node q = dummy;

        while (p != null) {
            q.next = p.next;
            q = q.next;
            p.next = p.next.next;
            p = p.next;
        }
        return dummy.next;
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
    private class Node implements Comparable<Node> {
        T value;
        Node next;
        Node random;

        Node() {next = random = null;}
        Node(T v) {
            value = v;
            next = null;
        }

        @Override
        public int compareTo(Node other) {
            return (Integer)value - (Integer)(other.value);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    ", random=" + random +
                    '}';
        }
    }
}

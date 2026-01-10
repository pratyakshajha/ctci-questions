package linkedlists;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LinkedListProblems {

    /**
     * CTCI 2.1: Remove Dups: Write code to remove duplicates from an unsorted linked list
     */
    public <T> Node<T> removeDuplicates(Node<T> head) {
        if (head == null) return null;

        Set<T> set = new HashSet<>();
        Node<T> current = head;
        Node<T> previous = null;
        while (current != null) {
            if (set.contains(current.value)) {
                previous.next = current.next;
            } else {
                set.add(current.value);
                previous = current;
            }
            current = current.next;
        }
        return head;
    }

    public <T> Node<T> removeDuplicatesNoBuffer(Node<T> head) {
        if (head == null) return null;
        Node<T> current = head;
        while (current != null) {
            T data = current.value;
            Node<T> runner = current;
            while (runner != null) {
                if (runner.next != null && runner.next.value == data)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;
            }
            current = current.next;
        }
        return head;
    }

    /**
     * CTCI 2.2: Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list
     */
    public <T> Node<T> kthToLast(Node<T> head, int k) {
        if (head == null) return null;

        Node<T> current = head;
        Node<T> kthNode = head;
        for (int i=0; i<k; i++) {
            if (kthNode.next == null) return null;
            kthNode = kthNode.next;
        }
        while (kthNode.next != null) {
            current = current.next;
            kthNode = kthNode.next;
        }
        return current;
    }

    /**
     * CTCI 2.3: Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the
     * first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
     */
    public <T> Node<T> deleteMiddle(Node<T> head) {
        if (head == null || head.next == null) return head;

        Node<T> fast = head;
        Node<T> slow = head;
        Node<T> prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    /**
     * CTCI 2.6: Palindrome: Implement a function to check if a linked list is a palindrome.
     */
    public <T> boolean isPalindrome(Node<T> head) {
        if (head == null) return true;
        if (head.next == null) return true;

        Node<T> current = head;
        Node<T> fast = head;
        Stack<Node<T>> stack = new Stack<>();
        while (fast != null && fast.next != null) {
            stack.push(current);
            current = current.next;
            fast = fast.next.next;
        }
        // for odd length
        if (fast != null) current = current.next;

        while (current != null) {
            if (current.value != stack.pop().value) return false;
            current = current.next;
        }
        return true;
    }

    /**
     * CTCI 2.7: Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
     */
    public <T> Node<T> findIntersectingNode(Node<T> h1, Node<T> h2) {
        if (h1 == null || h2 == null) return null;

        int l1 = length(h1);
        int l2 = length(h2);

        Node<T> big = l1 > l2 ? h1 : h2;
        Node<T> small = l1 > l2 ? h2 : h1;

        int i = Math.abs(l1 - l2);
        while (i > 0 && big != null) {
            big = big.next;
            i--;
        }
        while (big != null && small != null) {
            if (big == small) return big;
            big = big.next;
            small = small.next;
        }
        return null;
    }

    public <T> int length(Node<T> head) {
        if (head == null) return 0;
        if (head.next == null) return 1;
        return 1 + length(head.next);
    }

    /**
     * CTCI 2.8: Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
     */
    public <T> Node<T> detectLoop(Node<T> head) {
        Node<T> fast = head;
        Node<T> current = head;

        // move to collision point
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            current = current.next;
            if (fast == current) break;
        }

        // no collision
        if (fast == null || fast.next == null) return null;

        // reset current to head to find start of loop
        current = head;
        while (current != fast) {
            current = current.next;
            fast = fast.next;
        }
        return fast;
    }

}

package linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListProblemsTest {

    @Test
    void removeDuplicates() {
        LinkedListProblems problems = new LinkedListProblems();

        // Test case 1: Empty list
//        assertNull(problems.removeDuplicates(null));

        // Test case 2: List with no duplicates
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
//        assertEquals("[ 1-> 2-> 3 ]", Node.printAsList(problems.removeDuplicates(head1)));

        // Test case 3: List with duplicates
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(1);
        head2.next.next.next = new Node(3);
        head2.next.next.next.next = new Node(2);
//        assertEquals("[ 1-> 2-> 3 ]", Node.printAsList(problems.removeDuplicates(head2)));

        // Test case 4: List with all duplicates
        Node head3 = new Node(5);
        head3.next = new Node(5);
        head3.next.next = new Node(5);
        assertEquals("[ 5 ]", Node.printAsList(problems.removeDuplicates(head3)));

        // Test case 5: List with one element
        Node head4 = new Node(10);
        assertEquals("[ 10 ]", Node.printAsList(problems.removeDuplicates(head4)));

        // Test case 6: Duplicates at the beginning
        Node head5 = new Node(1);
        head5.next = new Node(1);
        head5.next.next = new Node(2);
        assertEquals("[ 1-> 2 ]", Node.printAsList(problems.removeDuplicates(head5)));

        // Test case 7: Duplicates at the end
        Node head6 = new Node(1);
        head6.next = new Node(2);
        head6.next.next = new Node(2);
        assertEquals("[ 1-> 2 ]", Node.printAsList(problems.removeDuplicates(head6)));

        // Test case 8: More complex duplicates
        Node head7 = new Node(1);
        head7.next = new Node(2);
        head7.next.next = new Node(3);
        head7.next.next.next = new Node(1);
        head7.next.next.next.next = new Node(4);
        head7.next.next.next.next.next = new Node(2);
        head7.next.next.next.next.next.next = new Node(5);
        assertEquals("[ 1-> 2-> 3-> 4-> 5 ]", Node.printAsList(problems.removeDuplicates(head7)));

        // Test case 9: More complex duplicates
        Node head8 = new Node(1);
        head8.next = new Node(5);
        head8.next.next = new Node(5);
        head8.next.next.next = new Node(5);
        head8.next.next.next.next = new Node(8);
        assertEquals("[ 1-> 5-> 8 ]", Node.printAsList(problems.removeDuplicates(head8)));
    }

    @Test
    void removeDuplicatesNoBuffer() {
        LinkedListProblems problems = new LinkedListProblems();

        // Test case 1: Empty list
        assertNull(problems.removeDuplicatesNoBuffer(null));

        // Test case 2: List with no duplicates
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        assertEquals("[ 1-> 2-> 3 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head1)));

        // Test case 3: List with duplicates
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(1);
        head2.next.next.next = new Node(3);
        head2.next.next.next.next = new Node(2);
        assertEquals("[ 1-> 2-> 3 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head2)));

        // Test case 4: List with all duplicates
        Node head3 = new Node(5);
        head3.next = new Node(5);
        head3.next.next = new Node(5);
        assertEquals("[ 5 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head3)));

        // Test case 5: List with one element
        Node head4 = new Node(10);
        assertEquals("[ 10 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head4)));

        // Test case 6: Duplicates at the beginning
        Node head5 = new Node(1);
        head5.next = new Node(1);
        head5.next.next = new Node(2);
        assertEquals("[ 1-> 2 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head5)));

        // Test case 7: Duplicates at the end
        Node head6 = new Node(1);
        head6.next = new Node(2);
        head6.next.next = new Node(2);
        assertEquals("[ 1-> 2 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head6)));

        // Test case 8: More complex duplicates
        Node head7 = new Node(1);
        head7.next = new Node(2);
        head7.next.next = new Node(3);
        head7.next.next.next = new Node(1);
        head7.next.next.next.next = new Node(4);
        head7.next.next.next.next.next = new Node(2);
        head7.next.next.next.next.next.next = new Node(5);
        assertEquals("[ 1-> 2-> 3-> 4-> 5 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head7)));
    }
}
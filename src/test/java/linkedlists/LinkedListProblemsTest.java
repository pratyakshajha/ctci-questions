package linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListProblemsTest {

    @Test
    void removeDuplicates() {
        LinkedListProblems problems = new LinkedListProblems();

        // Test case 1: Empty list
        assertNull(problems.removeDuplicates(null));

        // Test case 2: List with no duplicates
        Node<Integer> head1 = new Node<>(1);
        head1.next = new Node<>(2);
        head1.next.next = new Node<>(3);
        assertEquals("[ 1-> 2-> 3 ]", Node.printAsList(problems.removeDuplicates(head1)));

        // Test case 3: List with duplicates
        Node<Integer>head2 = new Node<>(1);
        head2.next = new Node<>(2);
        head2.next.next = new Node<>(1);
        head2.next.next.next = new Node<>(3);
        head2.next.next.next.next = new Node<>(2);
        assertEquals("[ 1-> 2-> 3 ]", Node.printAsList(problems.removeDuplicates(head2)));

        // Test case 4: List with all duplicates
        Node<Integer>head3 = new Node<>(5);
        head3.next = new Node<>(5);
        head3.next.next = new Node<>(5);
        assertEquals("[ 5 ]", Node.printAsList(problems.removeDuplicates(head3)));

        // Test case 5: List with one element
        Node<Integer>head4 = new Node<>(10);
        assertEquals("[ 10 ]", Node.printAsList(problems.removeDuplicates(head4)));

        // Test case 6: Duplicates at the beginning
        Node<Integer>head5 = new Node<>(1);
        head5.next = new Node<>(1);
        head5.next.next = new Node<>(2);
        assertEquals("[ 1-> 2 ]", Node.printAsList(problems.removeDuplicates(head5)));

        // Test case 7: Duplicates at the end
        Node<Integer>head6 = new Node<>(1);
        head6.next = new Node<>(2);
        head6.next.next = new Node<>(2);
        assertEquals("[ 1-> 2 ]", Node.printAsList(problems.removeDuplicates(head6)));

        // Test case 8: More complex duplicates
        Node<Integer>head7 = new Node<>(1);
        head7.next = new Node<>(2);
        head7.next.next = new Node<>(3);
        head7.next.next.next = new Node<>(1);
        head7.next.next.next.next = new Node<>(4);
        head7.next.next.next.next.next = new Node<>(2);
        head7.next.next.next.next.next.next = new Node<>(5);
        assertEquals("[ 1-> 2-> 3-> 4-> 5 ]", Node.printAsList(problems.removeDuplicates(head7)));

        // Test case 9: More complex duplicates
        Node<Integer>head8 = new Node<>(1);
        head8.next = new Node<>(5);
        head8.next.next = new Node<>(5);
        head8.next.next.next = new Node<>(5);
        head8.next.next.next.next = new Node<>(8);
        assertEquals("[ 1-> 5-> 8 ]", Node.printAsList(problems.removeDuplicates(head8)));

        // Test case 10: String data type
        Node<String> head9 = new Node<>("a");
        head9.next = new Node<>("b");
        head9.next.next = new Node<>("a");
        head9.next.next.next = new Node<>("c");
        assertEquals("[ a-> b-> c ]", Node.printAsList(problems.removeDuplicates(head9)));
    }

    @Test
    void removeDuplicatesNoBuffer() {
        LinkedListProblems problems = new LinkedListProblems();

        // Test case 1: Empty list
        assertNull(problems.removeDuplicatesNoBuffer(null));

        // Test case 2: List with no duplicates
        Node<Integer>head1 = new Node<>(1);
        head1.next = new Node<>(2);
        head1.next.next = new Node<>(3);
        assertEquals("[ 1-> 2-> 3 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head1)));

        // Test case 3: List with duplicates
        Node<Integer>head2 = new Node<>(1);
        head2.next = new Node<>(2);
        head2.next.next = new Node<>(1);
        head2.next.next.next = new Node<>(3);
        head2.next.next.next.next = new Node<>(2);
        assertEquals("[ 1-> 2-> 3 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head2)));

        // Test case 4: List with all duplicates
        Node<Integer>head3 = new Node<>(5);
        head3.next = new Node<>(5);
        head3.next.next = new Node<>(5);
        assertEquals("[ 5 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head3)));

        // Test case 5: List with one element
        Node<Integer>head4 = new Node<>(10);
        assertEquals("[ 10 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head4)));

        // Test case 6: Duplicates at the beginning
        Node<Integer>head5 = new Node<>(1);
        head5.next = new Node<>(1);
        head5.next.next = new Node<>(2);
        assertEquals("[ 1-> 2 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head5)));

        // Test case 7: Duplicates at the end
        Node<Integer>head6 = new Node<>(1);
        head6.next = new Node<>(2);
        head6.next.next = new Node<>(2);
        assertEquals("[ 1-> 2 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head6)));

        // Test case 8: More complex duplicates
        Node<Integer>head7 = new Node<>(1);
        head7.next = new Node<>(2);
        head7.next.next = new Node<>(3);
        head7.next.next.next = new Node<>(1);
        head7.next.next.next.next = new Node<>(4);
        head7.next.next.next.next.next = new Node<>(2);
        head7.next.next.next.next.next.next = new Node<>(5);
        assertEquals("[ 1-> 2-> 3-> 4-> 5 ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head7)));

        // Test case 9: String data type
        Node<String> head8 = new Node<>("hello");
        head8.next = new Node<>("world");
        head8.next.next = new Node<>("hello");
        assertEquals("[ hello-> world ]", Node.printAsList(problems.removeDuplicatesNoBuffer(head8)));
    }

    @Test
    void kthToLast() {
        LinkedListProblems problems = new LinkedListProblems();

        // Test case 1: Empty list
        assertNull(problems.kthToLast(null, 1));

        // Test case 2: Single element list, k=0
        Node<Integer>head1 = new Node<>(1);
        assertEquals(1, problems.kthToLast(head1, 0).value);

        // Test case 3: Single element list, k=1 (should be null as it's 1st to last, but list has only 1 element)
        assertNull(problems.kthToLast(head1, 1));

        // Test case 4: List with multiple elements, k=0 (last element)
        Node<Integer>head2 = new Node<>(1);
        head2.next = new Node<>(2);
        head2.next.next = new Node<>(3);
        assertEquals(3, problems.kthToLast(head2, 0).value);

        // Test case 5: List with multiple elements, k=1 (second to last)
        assertEquals(2, problems.kthToLast(head2, 1).value);

        // Test case 6: List with multiple elements, k=2 (third to last, which is head)
        assertEquals(1, problems.kthToLast(head2, 2).value);

        // Test case 7: List with multiple elements, k too large
        assertNull(problems.kthToLast(head2, 3));
        assertNull(problems.kthToLast(head2, 10));

        // Test case 8: Longer list
        Node<Integer>head3 = new Node<>(10);
        head3.next = new Node<>(20);
        head3.next.next = new Node<>(30);
        head3.next.next.next = new Node<>(40);
        head3.next.next.next.next = new Node<>(50);
        assertEquals(50, problems.kthToLast(head3, 0).value);
        assertEquals(40, problems.kthToLast(head3, 1).value);
        assertEquals(30, problems.kthToLast(head3, 2).value);

        // Test case 9: String data type
        Node<String> head4 = new Node<>("a");
        head4.next = new Node<>("b");
        head4.next.next = new Node<>("c");
        head4.next.next.next = new Node<>("d");
        assertEquals("c", problems.kthToLast(head4, 1).value);
    }

    @Test
    void deleteMiddle() {
        LinkedListProblems problems = new LinkedListProblems();

        // Test case 1: Empty list
        assertNull(problems.deleteMiddle(null));

        // Test case 2: Single Node<Integer>list (cannot delete middle)
        Node<Integer>head1 = new Node<>(1);
        assertEquals("[ 1 ]", Node.printAsList(problems.deleteMiddle(head1)));

        // Test case 3: Two Node<Integer>list (cannot delete middle)
        Node<Integer>head2 = new Node<>(1);
        head2.next = new Node<>(2);
        assertEquals("[ 1 ]", Node.printAsList(problems.deleteMiddle(head2)));

        // Test case 4: Three Node<Integer>list (delete middle)
        Node<Integer>head3 = new Node<>(1);
        head3.next = new Node<>(2);
        head3.next.next = new Node<>(3);
        assertEquals("[ 1-> 3 ]", Node.printAsList(problems.deleteMiddle(head3)));

        // Test case 5: Four Node<Integer>list (delete one of the two middle nodes, the first one)
        Node<Integer>head4 = new Node<>(1);
        head4.next = new Node<>(2);
        head4.next.next = new Node<>(3);
        head4.next.next.next = new Node<>(4);
        assertEquals("[ 1-> 2-> 4 ]", Node.printAsList(problems.deleteMiddle(head4)));

        // Test case 6: Five Node<Integer>list (delete middle)
        Node<Integer>head5 = new Node<>(1);
        head5.next = new Node<>(2);
        head5.next.next = new Node<>(3);
        head5.next.next.next = new Node<>(4);
        head5.next.next.next.next = new Node<>(5);
        assertEquals("[ 1-> 2-> 4-> 5 ]", Node.printAsList(problems.deleteMiddle(head5)));

        // Test case 7: Longer list
        Node<Integer>head6 = new Node<>(10);
        head6.next = new Node<>(20);
        head6.next.next = new Node<>(30);
        head6.next.next.next = new Node<>(40);
        head6.next.next.next.next = new Node<>(50);
        head6.next.next.next.next.next = new Node<>(60);
        assertEquals("[ 10-> 20-> 30-> 50-> 60 ]", Node.printAsList(problems.deleteMiddle(head6)));

        // Test case 8: String data type
        Node<String> head7 = new Node<>("first");
        head7.next = new Node<>("second");
        head7.next.next = new Node<>("third");
        head7.next.next.next = new Node<>("fourth");
        assertEquals("[ first-> second-> fourth ]", Node.printAsList(problems.deleteMiddle(head7)));

    }

    @Test
    void isPalindrome() {
        LinkedListProblems problems = new LinkedListProblems();

        // Test case 1: Empty list
        assertTrue(problems.isPalindrome(null));

        // Test case 2: Single Node<Integer>list
        Node<Integer>head1 = new Node<>(1);
        assertTrue(problems.isPalindrome(head1));

        // Test case 3: Two Node<Integer>list, palindrome
        Node<Integer>head2 = new Node<>(1);
        head2.next = new Node<>(1);
        assertTrue(problems.isPalindrome(head2));

        // Test case 4: Two Node<Integer>list, not palindrome
        Node<Integer>head3 = new Node<>(1);
        head3.next = new Node<>(2);
        assertFalse(problems.isPalindrome(head3));

        // Test case 5: Odd length palindrome
        Node<Integer>head4 = new Node<>(1);
        head4.next = new Node<>(2);
        head4.next.next = new Node<>(1);
        assertTrue(problems.isPalindrome(head4));

        // Test case 6: Even length palindrome
        Node<Integer>head5 = new Node<>(1);
        head5.next = new Node<>(2);
        head5.next.next = new Node<>(2);
        head5.next.next.next = new Node<>(1);
        assertTrue(problems.isPalindrome(head5));

        // Test case 7: Odd length not palindrome
        Node<Integer>head6 = new Node<>(1);
        head6.next = new Node<>(2);
        head6.next.next = new Node<>(3);
        assertFalse(problems.isPalindrome(head6));

        // Test case 8: Even length not palindrome
        Node<Integer>head7 = new Node<>(1);
        head7.next = new Node<>(2);
        head7.next.next = new Node<>(3);
        head7.next.next.next = new Node<>(4);
        assertFalse(problems.isPalindrome(head7));

        // Test case 9: Longer palindrome
        Node<Integer>head8 = new Node<>(1);
        head8.next = new Node<>(2);
        head8.next.next = new Node<>(3);
        head8.next.next.next = new Node<>(2);
        head8.next.next.next.next = new Node<>(1);
        assertTrue(problems.isPalindrome(head8));

        // Test case 10: Longer not palindrome
        Node<Integer>head9 = new Node<>(1);
        head9.next = new Node<>(2);
        head9.next.next = new Node<>(3);
        head9.next.next.next = new Node<>(4);
        head9.next.next.next.next = new Node<>(5);
        assertFalse(problems.isPalindrome(head9));

        // Test case 11: String data type palindrome
        Node<String> head10 = new Node<>("r");
        head10.next = new Node<>("a");
        head10.next.next = new Node<>("c");
        head10.next.next.next = new Node<>("e");
        head10.next.next.next.next = new Node<>("c");
        head10.next.next.next.next.next = new Node<>("a");
        head10.next.next.next.next.next.next = new Node<>("r");
        assertTrue(problems.isPalindrome(head10));
    }

    @Test
    void findIntersectingNode() {
        LinkedListProblems problems = new LinkedListProblems();

        // Test case 1: No intersection
        Node<Integer>head1_1 = new Node<>(1);
        head1_1.next = new Node<>(2);
        head1_1.next.next = new Node<>(3);

        Node<Integer>head1_2 = new Node<>(4);
        head1_2.next = new Node<>(5);
        assertNull(problems.findIntersectingNode(head1_1, head1_2));

        // Test case 2: Intersection at the end
        Node<Integer>commonNode1 = new Node<>(7);
        Node<Integer>head2_1 = new Node<>(1);
        head2_1.next = new Node<>(2);
        head2_1.next.next = commonNode1;

        Node<Integer>head2_2 = new Node<>(4);
        head2_2.next = new Node<>(5);
        head2_2.next.next = commonNode1;
        assertEquals(commonNode1, problems.findIntersectingNode(head2_1, head2_2));

        // Test case 3: Intersection in the middle
        Node<Integer>commonNode2 = new Node<>(8);
        commonNode2.next = new Node<>(9);
        Node<Integer>head3_1 = new Node<>(1);
        head3_1.next = new Node<>(2);
        head3_1.next.next = commonNode2;

        Node<Integer>head3_2 = new Node<>(4);
        head3_2.next = new Node<>(5);
        head3_2.next.next = new Node<>(6);
        head3_2.next.next.next = commonNode2;
        assertEquals(commonNode2, problems.findIntersectingNode(head3_1, head3_2));

        // Test case 4: Same list (intersection at head)
        Node<Integer>head4 = new Node<>(1);
        head4.next = new Node<>(2);
        head4.next.next = new Node<>(3);
        assertEquals(head4, problems.findIntersectingNode(head4, head4));

        // Test case 5: One list is null
        Node<Integer>head5_1 = new Node<>(1);
        assertNull(problems.findIntersectingNode(head5_1, null));
        assertNull(problems.findIntersectingNode(null, head5_1));

        // Test case 6: Intersection at the head of the shorter list
        Node<Integer>commonNode3 = new Node<>(10);
        commonNode3.next = new Node<>(11);
        Node<Integer>head6_1 = new Node<>(1);
        head6_1.next = new Node<>(2);
        head6_1.next.next = commonNode3;

        Node<Integer>head6_2 = commonNode3;
        assertEquals(commonNode3, problems.findIntersectingNode(head6_1, head6_2));

        // Test case 7: No intersection, but same length
        Node<Integer>head7_1 = new Node<>(1);
        head7_1.next = new Node<>(2);
        head7_1.next.next = new Node<>(3);

        Node<Integer>head7_2 = new Node<>(4);
        head7_2.next = new Node<>(5);
        head7_2.next.next = new Node<>(6);
        assertNull(problems.findIntersectingNode(head7_1, head7_2));

        // Test case 8: Intersection after some non-intersecting nodes
        Node<Integer>commonNode4 = new Node<>(20);
        commonNode4.next = new Node<>(21);
        Node<Integer>head8_1 = new Node<>(1);
        head8_1.next = new Node<>(2);
        head8_1.next.next = new Node<>(3);
        head8_1.next.next.next = commonNode4;

        Node<Integer>head8_2 = new Node<>(10);
        head8_2.next = new Node<>(11);
        head8_2.next.next = commonNode4;
        assertEquals(commonNode4, problems.findIntersectingNode(head8_1, head8_2));

        // Test case 9: String data type
        Node<String> commonNode5 = new Node<>("intersect");
        commonNode5.next = new Node<>("end");
        Node<String> head9_1 = new Node<>("one");
        head9_1.next = new Node<>("two");
        head9_1.next.next = commonNode5;

        Node<String> head9_2 = new Node<>("alpha");
        head9_2.next = new Node<>("beta");
        head9_2.next.next = commonNode5;
        assertEquals(commonNode5, problems.findIntersectingNode(head9_1, head9_2));
    }

    @Test
    void length() {
        LinkedListProblems problems = new LinkedListProblems();

        // Test case 1: Empty list
        assertEquals(0, problems.length(null));

        // Test case 2: Single Node<Integer>list
        Node<Integer>head1 = new Node<>(1);
        assertEquals(1, problems.length(head1));

        // Test case 3: Two Node<Integer>list
        Node<Integer>head2 = new Node<>(1);
        head2.next = new Node<>(2);
        assertEquals(2, problems.length(head2));

        // Test case 4: Multiple Node<Integer>list
        Node<Integer>head3 = new Node<>(1);
        head3.next = new Node<>(2);
        head3.next.next = new Node<>(3);
        head3.next.next.next = new Node<>(4);
        assertEquals(4, problems.length(head3));

        // Test case 5: Longer list
        Node<Integer>head4 = new Node<>(1);
        Node<Integer>current = head4;
        for (int i = 2; i <= 10; i++) {
            current.next = new Node<>(i);
            current = current.next;
        }
        assertEquals(10, problems.length(head4));

        // Test case 6: String data type
        Node<String> head5 = new Node<>("apple");
        head5.next = new Node<>("banana");
        head5.next.next = new Node<>("cherry");
        assertEquals(3, problems.length(head5));
    }

    @Test
    void detectLoop() {
        LinkedListProblems problems = new LinkedListProblems();

        // Test case 1: No loop (empty list)
        assertNull(problems.detectLoop(null));

        // Test case 2: No loop (single node)
        Node<Integer> head1 = new Node<>(1);
        assertNull(problems.detectLoop(head1));

        // Test case 3: No loop (multiple nodes)
        Node<Integer> head2 = new Node<>(1);
        head2.next = new Node<>(2);
        head2.next.next = new Node<>(3);
        assertNull(problems.detectLoop(head2));

        // Test case 4: Loop at the head
        Node<Integer> head3 = new Node<>(1);
        Node<Integer> node3_2 = new Node<>(2);
        Node<Integer> node3_3 = new Node<>(3);
        head3.next = node3_2;
        node3_2.next = node3_3;
        node3_3.next = head3; // Loop: 3 -> 1
        assertEquals(head3, problems.detectLoop(head3));

        // Test case 5: Loop in the middle
        Node<Integer> head4 = new Node<>(1);
        Node<Integer> node4_2 = new Node<>(2);
        Node<Integer> node4_3 = new Node<>(3);
        Node<Integer> node4_4 = new Node<>(4);
        Node<Integer> node4_5 = new Node<>(5);
        head4.next = node4_2;
        node4_2.next = node4_3;
        node4_3.next = node4_4;
        node4_4.next = node4_5;
        node4_5.next = node4_3; // Loop: 5 -> 3
        assertEquals(node4_3, problems.detectLoop(head4));

        // Test case 6: Loop at the end (last node points to itself)
        Node<Integer> head5 = new Node<>(1);
        Node<Integer> node5_2 = new Node<>(2);
        Node<Integer> node5_3 = new Node<>(3);
        head5.next = node5_2;
        node5_2.next = node5_3;
        node5_3.next = node5_3; // Loop: 3 -> 3
        assertEquals(node5_3, problems.detectLoop(head5));

        // Test case 7: Loop with two nodes
        Node<Integer> head6 = new Node<>(1);
        Node<Integer> node6_2 = new Node<>(2);
        head6.next = node6_2;
        node6_2.next = head6; // Loop: 2 -> 1
        assertEquals(head6, problems.detectLoop(head6));

        // Test case 8: Longer list with loop
        Node<Integer> head7 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n4 = new Node<>(4);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n7 = new Node<>(7);
        Node<Integer> n8 = new Node<>(8);

        head7.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n4; // Loop: 8 -> 4
        assertEquals(n4, problems.detectLoop(head7));

        // Test case 9: String data type with loop
        Node<String> head8 = new Node<>("a");
        Node<String> s2 = new Node<>("b");
        Node<String> s3 = new Node<>("c");
        head8.next = s2;
        s2.next = s3;
        s3.next = s2; // Loop: c -> b
        assertEquals(s2, problems.detectLoop(head8));
    }
}
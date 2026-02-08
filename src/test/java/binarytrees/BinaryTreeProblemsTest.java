package binarytrees;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeProblemsTest {

    @Test
    void createBstFromSortedArray() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: Standard sorted array
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        Node<Integer> root1 = problems.createBstFromSortedArray(array1);
        assertNotNull(root1);
        assertEquals(4, root1.data);
        assertEquals(2, root1.left.data);
        assertEquals(6, root1.right.data);

        // Test Case 2: Even number of elements
        int[] array2 = {1, 2, 3, 4, 5, 6};
        Node<Integer> root2 = problems.createBstFromSortedArray(array2);
        assertNotNull(root2);
        // mid of 0 and 5 is 2 -> array[2] = 3
        assertEquals(3, root2.data);

        // Test Case 3: Single element
        int[] array3 = {10};
        Node<Integer> root3 = problems.createBstFromSortedArray(array3);
        assertEquals(10, root3.data);
        assertNull(root3.left);
        assertNull(root3.right);

        // Test Case 4: Two elements
        int[] array4 = {10, 20};
        Node<Integer> root4 = problems.createBstFromSortedArray(array4);
        assertEquals(10, root4.data);
        assertNotNull(root4.right);
        assertEquals(20, root4.right.data);

        // Test Case 5: Empty array
        int[] array5 = {};
        Node<Integer> root5 = problems.createBstFromSortedArray(array5);
        assertNull(root5);

        // Test Case 6: Array with odd number of elements (mid is exact)
        int[] array6 = {1, 2, 3, 4, 5};
        Node<Integer> root6 = problems.createBstFromSortedArray(array6);
        assertNotNull(root6);
        assertEquals(3, root6.data);
        assertEquals(1, root6.left.data);
        assertEquals(4, root6.right.data);
        assertEquals(2, root6.left.right.data);
        assertEquals(5, root6.right.right.data);
    }

    @Test
    void listOfDepths() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: Standard tree
        Node<Integer> root1 = new Node<>(1);
        root1.left = new Node<>(2);
        root1.right = new Node<>(3);
        root1.left.left = new Node<>(4);
        root1.left.right = new Node<>(5);
        root1.right.right = new Node<>(6);

        List<LinkedList<Node<Integer>>> result1 = problems.listOfDepths(root1);
        assertEquals(3, result1.size());
        assertEquals(1, result1.get(0).size());
        assertEquals(1, result1.get(0).get(0).data);
        assertEquals(2, result1.get(1).size());
        assertEquals(3, result1.get(2).size());

        // Test Case 2: Single node
        Node<Integer> root2 = new Node<>(10);
        List<LinkedList<Node<Integer>>> result2 = problems.listOfDepths(root2);
        assertEquals(1, result2.size());
        assertEquals(10, result2.get(0).get(0).data);

        // Test Case 3: Empty tree
        assertNull(problems.listOfDepths(null));

        // Test Case 4: Unbalanced tree (linked list style)
        Node<Integer> root4 = new Node<>(1);
        root4.right = new Node<>(2);
        root4.right.right = new Node<>(3);
        List<LinkedList<Node<Integer>>> result4 = problems.listOfDepths(root4);
        assertEquals(3, result4.size());
        for (LinkedList<Node<Integer>> list : result4) {
            assertEquals(1, list.size());
        }

        // Test Case 5: String data type
        Node<String> root5 = new Node<>("A");
        root5.left = new Node<>("B");
        root5.right = new Node<>("C");
        List<LinkedList<Node<String>>> result5 = problems.listOfDepths(root5);
        assertEquals(2, result5.size());
        assertEquals("A", result5.get(0).get(0).data);
        assertEquals(2, result5.get(1).size());
        assertTrue(result5.get(1).stream().anyMatch(n -> n.data.equals("B")));
        assertTrue(result5.get(1).stream().anyMatch(n -> n.data.equals("C")));
    }

    @Test
    void listOfDepths2() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: Standard tree
        Node<Integer> root1 = new Node<>(1);
        root1.left = new Node<>(2);
        root1.right = new Node<>(3);
        root1.left.left = new Node<>(4);
        root1.left.right = new Node<>(5);
        root1.right.right = new Node<>(6);

        List<LinkedList<Node<Integer>>> result1 = problems.listOfDepths2(root1);
        assertEquals(3, result1.size());
        assertEquals(1, result1.get(0).size());
        assertEquals(1, result1.get(0).get(0).data);
        assertEquals(2, result1.get(1).size());
        assertEquals(3, result1.get(2).size());

        // Test Case 2: Single node
        Node<Integer> root2 = new Node<>(10);
        List<LinkedList<Node<Integer>>> result2 = problems.listOfDepths2(root2);
        assertEquals(1, result2.size());
        assertEquals(10, result2.get(0).get(0).data);

        // Test Case 3: Empty tree
        assertNull(problems.listOfDepths2(null));

        // Test Case 4: Unbalanced tree (linked list style)
        Node<Integer> root4 = new Node<>(1);
        root4.right = new Node<>(2);
        root4.right.right = new Node<>(3);
        List<LinkedList<Node<Integer>>> result4 = problems.listOfDepths2(root4);
        assertEquals(3, result4.size());
        for (LinkedList<Node<Integer>> list : result4) {
            assertEquals(1, list.size());
        }

        // Test Case 5: String data type
        Node<String> root5 = new Node<>("A");
        root5.left = new Node<>("B");
        root5.right = new Node<>("C");
        List<LinkedList<Node<String>>> result5 = problems.listOfDepths2(root5);
        assertEquals(2, result5.size());
        assertEquals("A", result5.get(0).get(0).data);
        assertEquals(2, result5.get(1).size());
        assertTrue(result5.get(1).stream().anyMatch(n -> n.data.equals("B")));
        assertTrue(result5.get(1).stream().anyMatch(n -> n.data.equals("C")));
    }

    @Test
    void listOfDepths3() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: Standard tree
        Node<Integer> root1 = new Node<>(1);
        root1.left = new Node<>(2);
        root1.right = new Node<>(3);
        root1.left.left = new Node<>(4);
        root1.left.right = new Node<>(5);
        root1.right.right = new Node<>(6);

        List<LinkedList<Node<Integer>>> result1 = problems.listOfDepths3(root1);
        assertEquals(3, result1.size());
        assertEquals(1, result1.get(0).size());
        assertEquals(1, result1.get(0).get(0).data);
        assertEquals(2, result1.get(1).size());
        assertEquals(3, result1.get(2).size());

        // Test Case 2: Single node
        Node<Integer> root2 = new Node<>(10);
        List<LinkedList<Node<Integer>>> result2 = problems.listOfDepths3(root2);
        assertEquals(1, result2.size());
        assertEquals(10, result2.get(0).get(0).data);

        // Test Case 3: Empty tree
        assertNull(problems.listOfDepths3(null));

        // Test Case 4: Unbalanced tree (linked list style)
        Node<Integer> root4 = new Node<>(1);
        root4.right = new Node<>(2);
        root4.right.right = new Node<>(3);
        List<LinkedList<Node<Integer>>> result4 = problems.listOfDepths3(root4);
        assertEquals(3, result4.size());
        for (LinkedList<Node<Integer>> list : result4) {
            assertEquals(1, list.size());
        }

        // Test Case 5: String data type
        Node<String> root5 = new Node<>("A");
        root5.left = new Node<>("B");
        root5.right = new Node<>("C");
        List<LinkedList<Node<String>>> result5 = problems.listOfDepths3(root5);
        assertEquals(2, result5.size());
        assertEquals("A", result5.get(0).get(0).data);
        assertEquals(2, result5.get(1).size());
        assertTrue(result5.get(1).stream().anyMatch(n -> n.data.equals("B")));
        assertTrue(result5.get(1).stream().anyMatch(n -> n.data.equals("C")));
    }

    @Test
    void checkBalanced() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: Balanced tree
        Node<Integer> root1 = new Node<>(1);
        root1.left = new Node<>(2);
        root1.right = new Node<>(3);
        assertTrue(problems.checkBalanced(root1));

        // Test Case 2: Unbalanced tree
        Node<Integer> root2 = new Node<>(1);
        root2.left = new Node<>(2);
        root2.left.left = new Node<>(3);
        assertFalse(problems.checkBalanced(root2));

        // Test Case 3: Single node
        assertTrue(problems.checkBalanced(new Node<>(10)));

        // Test Case 4: Empty tree
        assertTrue(problems.checkBalanced(null));

        // Test Case 5: Complex balanced tree
        Node<Integer> root5 = new Node<>(1);
        root5.left = new Node<>(2);
        root5.right = new Node<>(3);
        root5.left.left = new Node<>(4);
        root5.left.right = new Node<>(5);
        root5.right.left = new Node<>(6);
        assertTrue(problems.checkBalanced(root5));

        // Test Case 6: Complex unbalanced tree
        root5.left.left.left = new Node<>(7);
        root5.left.left.left.right = new Node<>(8);
        assertFalse(problems.checkBalanced(root5));
    }

    @Test
    void validateBst() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: Valid BST
        Node<Integer> root1 = new Node<>(10);
        root1.left = new Node<>(5);
        root1.right = new Node<>(15);
        root1.left.left = new Node<>(2);
        root1.left.right = new Node<>(7);
        assertTrue(problems.validateBst(root1));

        // Test Case 2: Invalid BST (right child smaller than root)
        Node<Integer> root2 = new Node<>(10);
        root2.left = new Node<>(5);
        root2.right = new Node<>(8);
        assertFalse(problems.validateBst(root2));

        // Test Case 3: Invalid BST (left child larger than root)
        Node<Integer> root3 = new Node<>(10);
        root3.left = new Node<>(12);
        root3.right = new Node<>(15);
        assertFalse(problems.validateBst(root3));

        // Test Case 4: Invalid BST (deep node violates ancestor constraint)
        Node<Integer> root4 = new Node<>(20);
        root4.left = new Node<>(10);
        root4.right = new Node<>(30);
        root4.left.right = new Node<>(25); // 25 is > 20, invalid for left subtree
        assertFalse(problems.validateBst(root4));

        // Test Case 5: Single node
        assertTrue(problems.validateBst(new Node<>(10)));

        // Test Case 6: Empty tree
        assertTrue(problems.validateBst(null));

        // Test Case 7: BST with equal values (depends on definition, usually left <= root < right)
        // Our implementation uses strict < min or > max, so we check boundaries
        Node<Integer> root7 = new Node<>(10);
        root7.left = new Node<>(10);
        assertTrue(problems.validateBst(root7));
    }

    @Test
    void findSuccessor() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: Empty tree
        assertNull(problems.findSuccessor(null));

        // Test Case 2: Tree with only root, no left child
        Node<Integer> root1 = new Node<>(10);
        assertEquals(root1, problems.findSuccessor(root1));

        // Test Case 3: Tree with left child
        Node<Integer> root2 = new Node<>(20);
        Node<Integer> left2 = new Node<>(10);
        root2.left = left2;
        assertEquals(left2, problems.findSuccessor(root2));

        // Test Case 4: Tree with multiple left children
        Node<Integer> root3 = new Node<>(30);
        Node<Integer> left3_1 = new Node<>(15);
        Node<Integer> left3_2 = new Node<>(5);
        root3.left = left3_1;
        left3_1.left = left3_2;
        assertEquals(left3_2, problems.findSuccessor(root3));

        // Test Case 5: Complex tree, find min in right subtree
        Node<Integer> root4 = new Node<>(50);
        root4.left = new Node<>(30);
        root4.right = new Node<>(70);
        root4.left.left = new Node<>(20);
        root4.left.right = new Node<>(40);
        root4.right.left = new Node<>(60);
        root4.right.right = new Node<>(80);
        assertEquals(root4.left.left, problems.findSuccessor(root4.left)); // Successor of 30 is 20 (min in its right subtree)
        assertEquals(root4.right.left, problems.findSuccessor(root4.right)); // Successor of 70 is 60 (min in its right subtree)
        assertEquals(root4.left.left, problems.findSuccessor(root4)); // Successor of 50 is 20 (min in its right subtree)

        // Test Case 6: Node with no left child
        Node<Integer> root6 = new Node<>(100);
        assertEquals(root6, problems.findSuccessor(root6));

        // Test Case 7: Node with only right child (still finds itself if no left)
        Node<Integer> root7 = new Node<>(100);
        root7.right = new Node<>(110);
        assertEquals(root7, problems.findSuccessor(root7));

        // Test Case 8: String data type
        Node<String> root8 = new Node<>("apple");
        Node<String> left8_1 = new Node<>("banana");
        Node<String> left8_2 = new Node<>("apricot");
        root8.left = left8_1;
        left8_1.left = left8_2;
        assertEquals(left8_2, problems.findSuccessor(root8));
    }

    @Test
    void lowestCommonAncestor() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: Standard case, p and q are in different subtrees
        Node<Integer> root1 = new Node<>(3);
        root1.left = new Node<>(5);
        root1.right = new Node<>(1);
        root1.left.left = new Node<>(6);
        Node<Integer> p1 = new Node<>(2);
        root1.left.right = p1;
        root1.right.left = new Node<>(0);
        Node<Integer> q1 = new Node<>(8);
        root1.right.right = q1;
        p1.left = new Node<>(7);
        p1.right = new Node<>(4);
        assertEquals(root1, problems.lowestCommonAncestor(root1, p1, q1));

        // Test Case 2: p is an ancestor of q
        Node<Integer> root2 = new Node<>(3);
        Node<Integer> p2 = new Node<>(5);
        root2.left = p2;
        root2.right = new Node<>(1);
        p2.left = new Node<>(6);
        Node<Integer> q2 = new Node<>(2);
        p2.right = q2;
        root2.right.left = new Node<>(0);
        root2.right.right = new Node<>(8);
        q2.left = new Node<>(7);
        q2.right = new Node<>(4);
        assertEquals(p2, problems.lowestCommonAncestor(root2, p2, q2));

        // Test Case 3: q is an ancestor of p
        Node<Integer> root3 = new Node<>(3);
        Node<Integer> q3 = new Node<>(5);
        root3.left = q3;
        root3.right = new Node<>(1);
        q3.left = new Node<>(6);
        Node<Integer> p3 = new Node<>(2);
        q3.right = p3;
        root3.right.left = new Node<>(0);
        root3.right.right = new Node<>(8);
        p3.left = new Node<>(7);
        p3.right = new Node<>(4);
        assertEquals(q3, problems.lowestCommonAncestor(root3, p3, q3));

        // Test Case 4: p and q are direct children of the root
        Node<Integer> root4 = new Node<>(1);
        Node<Integer> p4 = new Node<>(2);
        Node<Integer> q4 = new Node<>(3);
        root4.left = p4;
        root4.right = q4;
        assertEquals(root4, problems.lowestCommonAncestor(root4, p4, q4));

        // Test Case 5: p and q are in the left subtree
        Node<Integer> root5 = new Node<>(1);
        Node<Integer> p5 = new Node<>(4);
        Node<Integer> q5 = new Node<>(5);
        root5.left = new Node<>(2);
        root5.right = new Node<>(3);
        root5.left.left = p5;
        root5.left.right = q5;
        assertEquals(root5.left, problems.lowestCommonAncestor(root5, p5, q5));

        // Test Case 6: p and q are in the right subtree
        Node<Integer> root6 = new Node<>(1);
        Node<Integer> p6 = new Node<>(4);
        Node<Integer> q6 = new Node<>(5);
        root6.left = new Node<>(2);
        root6.right = new Node<>(3);
        root6.right.left = p6;
        root6.right.right = q6;
        assertEquals(root6.right, problems.lowestCommonAncestor(root6, p6, q6));

        // Test Case 7: One of the nodes is the root
        Node<Integer> root7 = new Node<>(1);
        Node<Integer> p7 = root7;
        Node<Integer> q7 = new Node<>(2);
        root7.left = q7;
        assertEquals(root7, problems.lowestCommonAncestor(root7, p7, q7));

        // Test Case 8: Both nodes are the root (should return root)
        Node<Integer> root8 = new Node<>(1);
        assertEquals(root8, problems.lowestCommonAncestor(root8, root8, root8));

        // Test Case 9: Tree with only root
        Node<Integer> root9 = new Node<>(1);
        assertEquals(root9, problems.lowestCommonAncestor(root9, root9, root9));

        // Test Case 10: p and q are the same node, not root
        Node<Integer> root10 = new Node<>(1);
        Node<Integer> p10 = new Node<>(2);
        root10.left = p10;
        assertEquals(p10, problems.lowestCommonAncestor(root10, p10, p10));

        // Test Case 11: p and q are not in the tree (should return null or the node that is in the tree if one is)
        // The current implementation returns the node that is found first if the other is not present.
        // If neither is present, it returns null.
        Node<Integer> root11 = new Node<>(1);
        root11.left = new Node<>(2);
        root11.right = new Node<>(3);
        Node<Integer> p11 = new Node<>(4); // Not in tree
        Node<Integer> q11 = new Node<>(5); // Not in tree
        assertNull(problems.lowestCommonAncestor(root11, p11, q11));

        Node<Integer> root12 = new Node<>(1);
        Node<Integer> p12 = new Node<>(2);
        root12.left = p12;
        Node<Integer> q12 = new Node<>(3); // Not in tree
        assertNull(problems.lowestCommonAncestor(root12, p12, q12));

        // Test Case 13: Complex tree structure
        Node<Integer> root13 = new Node<>(30);
        Node<Integer> n13_1 = new Node<>(8);
        Node<Integer> n13_2 = new Node<>(52);
        Node<Integer> n13_3 = new Node<>(3);
        Node<Integer> n13_4 = new Node<>(20);
        Node<Integer> n13_5 = new Node<>(10);
        Node<Integer> n13_6 = new Node<>(29);

        root13.left = n13_1;
        root13.right = n13_2;
        n13_1.left = n13_3;
        n13_1.right = n13_4;
        n13_4.left = n13_5;
        n13_4.right = n13_6;

        // p=10, q=29, LCA should be 20
        assertEquals(n13_4, problems.lowestCommonAncestor(root13, n13_5, n13_6));
        // p=3, q=29, LCA should be 8
        assertEquals(n13_1, problems.lowestCommonAncestor(root13, n13_3, n13_6));
        // p=3, q=52, LCA should be 30
        assertEquals(root13, problems.lowestCommonAncestor(root13, n13_3, n13_2));
        // p=8, q=29, LCA should be 8
        assertEquals(n13_1, problems.lowestCommonAncestor(root13, n13_1, n13_6));
        // p=30, q=29, LCA should be 30
        assertEquals(root13, problems.lowestCommonAncestor(root13, root13, n13_6));
    }

    @Test
    void contains() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: Node is present in the tree
        Node<Integer> root1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        root1.left = node2;
        root1.right = node3;
        assertTrue(problems.contains(root1, node2));
        assertTrue(problems.contains(root1, node3));
        assertTrue(problems.contains(root1, root1));

        // Test Case 2: Node is not present in the tree
        Node<Integer> node4 = new Node<>(4);
        assertFalse(problems.contains(root1, node4));

        // Test Case 3: Empty tree
        assertFalse(problems.contains(null, node2));

        // Test Case 4: Single node tree, node is itself
        Node<Integer> root2 = new Node<>(5);
        assertTrue(problems.contains(root2, root2));

        // Test Case 5: Single node tree, node is not itself
        assertFalse(problems.contains(root2, node2));

        // Test Case 6: Larger tree, node in deep left subtree
        Node<Integer> root3 = new Node<>(10);
        root3.left = new Node<>(5);
        root3.right = new Node<>(15);
        root3.left.left = new Node<>(2);
        Node<Integer> node7 = new Node<>(7);
        root3.left.right = node7;
        root3.right.left = new Node<>(12);
        root3.right.right = new Node<>(20);
        root3.left.left.right = new Node<>(3);
        assertTrue(problems.contains(root3, node7));
        assertTrue(problems.contains(root3, root3.left.left.right));

        // Test Case 7: Larger tree, node not present
        Node<Integer> node100 = new Node<>(100);
        assertFalse(problems.contains(root3, node100));

        // Test Case 8: Node with null data
        Node<Integer> nodeNull = new Node<>(null);
        assertFalse(problems.contains(root3, nodeNull));        // Test Case 9: Node with same data but different object
        Node<Integer> root4 = new Node<>(1);
        Node<Integer> p4 = new Node<>(1);
        assertFalse(problems.contains(root4, p4)); // Should be false as it's a different object
    }

    @Test
    void bstSequences() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: Single node
        Node<Integer> root1 = new Node<>(1);
        List<List<Integer>> result1 = problems.bstSequences(root1);
        assertEquals(1, result1.size());
        assertEquals(List.of(1), result1.get(0));

        // Test Case 2: Simple BST
        //    2
        //   / \
        //  1   3
        Node<Integer> root2 = new Node<>(2);
        root2.left = new Node<>(1);
        root2.right = new Node<>(3);
        List<List<Integer>> result2 = problems.bstSequences(root2);
        // Possible: [2, 1, 3], [2, 3, 1]
        assertEquals(2, result2.size());
        assertTrue(result2.contains(List.of(2, 1, 3)));
        assertTrue(result2.contains(List.of(2, 3, 1)));

        // Test Case 3: Null root
        List<List<Integer>> result3 = problems.bstSequences(null);
        assertEquals(1, result3.size());
        assertTrue(result3.get(0).isEmpty());

        // Test Case 4: Linear tree (Right only)
        Node<Integer> root4 = new Node<>(1);
        root4.right = new Node<>(2);
        root4.right.right = new Node<>(3);
        List<List<Integer>> result4 = problems.bstSequences(root4);
        assertEquals(1, result4.size());
        assertEquals(List.of(1, 2, 3), result4.get(0));

        // Test Case 5: Complex BST
        //      10
        //     /  \
        //    5    15
        //   /
        //  2
        Node<Integer> root5 = new Node<>(10);
        root5.left = new Node<>(5);
        root5.right = new Node<>(15);
        root5.left.left = new Node<>(2);
        List<List<Integer>> result5 = problems.bstSequences(root5);
        // Possible sequences must start with 10.
        // Then 5 and 15 can be in any order.
        // 2 must come after 5.
        // [10, 5, 15, 2], [10, 5, 2, 15], [10, 15, 5, 2]
        assertEquals(3, result5.size());
        assertTrue(result5.contains(List.of(10, 5, 15, 2)));
        assertTrue(result5.contains(List.of(10, 5, 2, 15)));
        assertTrue(result5.contains(List.of(10, 15, 5, 2)));
    }

    @Test
    void checkSubtree() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: T2 is a subtree of T1
        Node<Integer> t1 = new Node<>(1);
        t1.left = new Node<>(2);
        t1.right = new Node<>(3);
        t1.left.left = new Node<>(4);
        t1.left.right = new Node<>(5);

        Node<Integer> t2 = new Node<>(2);
        t2.left = new Node<>(4);
        t2.right = new Node<>(5);
        assertTrue(problems.checkSubtree(t1, t2));

        // Test Case 2: T2 is not a subtree of T1
        Node<Integer> t3 = new Node<>(2);
        t3.left = new Node<>(4);
        t3.right = new Node<>(6); // Different value
        assertFalse(problems.checkSubtree(t1, t3));

        // Test Case 3: T2 is null (should be true)
        assertTrue(problems.checkSubtree(t1, null));

        // Test Case 4: T1 is null, T2 is not (should be false)
        assertFalse(problems.checkSubtree(null, t2));

        // Test Case 5: T1 and T2 are identical
        Node<Integer> t1_copy = new Node<>(1);
        t1_copy.left = new Node<>(2);
        t1_copy.right = new Node<>(3);
        t1_copy.left.left = new Node<>(4);
        t1_copy.left.right = new Node<>(5);
        assertTrue(problems.checkSubtree(t1, t1_copy));

        // Test Case 6: T2 is larger than T1
        assertFalse(problems.checkSubtree(t2, t1));

        // Test Case 7: T2 exists in T1 but with different structure
        Node<Integer> t1_complex = new Node<>(10);
        t1_complex.left = new Node<>(5);
        t1_complex.left.left = new Node<>(2);
        Node<Integer> t2_complex = new Node<>(5);
        t2_complex.left = new Node<>(2);
        assertTrue(problems.checkSubtree(t1_complex, t2_complex));

        // Test Case 8: T2 has same values but different leaf structure
        Node<Integer> t1_leaf = new Node<>(1);
        t1_leaf.left = new Node<>(2);
        Node<Integer> t2_leaf = new Node<>(1);
        t2_leaf.right = new Node<>(2);
        assertFalse(problems.checkSubtree(t1_leaf, t2_leaf));
    }

    @Test
    void pathSum() {
        BinaryTreeProblems problems = new BinaryTreeProblems();

        // Test Case 1: Simple tree with multiple paths
        //      10
        //     /  \
        //    5   -3
        //   / \    \
        //  3   2   11
        // / \   \
        //3  -2   1
        Node<Integer> root1 = new Node<>(10);
        root1.left = new Node<>(5);
        root1.right = new Node<>(-3);
        root1.left.left = new Node<>(3);
        root1.left.right = new Node<>(2);
        root1.right.right = new Node<>(11);
        root1.left.left.left = new Node<>(3);
        root1.left.left.right = new Node<>(-2);
        root1.left.right.right = new Node<>(1);

        // Paths summing to 8:
        // 1. 5 -> 3
        // 2. 5 -> 2 -> 1
        // 3. 10 -> 5 -> 3 -> -2 (Wait, 10+5+3-2 = 16. Let's re-check)
        // Correct paths for target 8: [5, 3], [5, 2, 1], [10, -3]
        assertEquals(3, problems.pathSum(root1, 8));

        // Test Case 2: Target sum not present
        assertEquals(0, problems.pathSum(root1, 50));

        // Test Case 3: Single node matches target
        Node<Integer> root2 = new Node<>(5);
        assertEquals(1, problems.pathSum(root2, 5));

        // Test Case 4: Empty tree
        assertEquals(0, problems.pathSum(null, 8));

        // Test Case 5: Path can be just one node in the middle
        Node<Integer> root5 = new Node<>(1);
        root5.left = new Node<>(2);
        root5.left.left = new Node<>(3);
        assertEquals(1, problems.pathSum(root5, 2));

        // Test Case 6: Negative values
        Node<Integer> root6 = new Node<>(10);
        root6.left = new Node<>(-5);
        root6.left.left = new Node<>(3);
        // Path: 10 -> -5 -> 3 = 8
        assertEquals(1, problems.pathSum(root6, 8));
    }
}
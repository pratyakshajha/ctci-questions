package binarytrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeProblemsTest {

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
}
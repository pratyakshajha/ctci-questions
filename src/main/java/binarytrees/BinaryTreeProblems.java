package binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeProblems {

    /**
     * CTCI 4.2: Minimal Tree: Given a sorted (increasing order) array with unique integer elements,
     * write an algorithm to create a binary search tree with minimal height.
     */
    public Node<Integer> createBstFromSortedArray(int[] array) {
        return createBstHelper(array, 0, array.length-1);
    }

    public Node<Integer> createBstHelper(int[] array, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        Node<Integer> root = new Node<>(array[mid]);
        root.left = createBstHelper(array, left, mid-1);
        root.right = createBstHelper(array, mid+1, right);
        return root;
    }

    /**
     * CTCI 4.3: List of Depths: Given a binary tree, design an algorithm which creates
     * a linked list of all the nodes at each depth.
     */
    public <T> List<LinkedList<Node<T>>> listOfDepths(Node<T> root) {
        if (root == null) return null;
        List<LinkedList<Node<T>>> result = new LinkedList<>();

        // do a BFS traversal
        Queue<Node<T>> toVisit = new LinkedList<>();
        toVisit.add(root);
        while (!toVisit.isEmpty()) {
            int level = toVisit.size();
            LinkedList<Node<T>> list = new LinkedList<>();
            for (int i=0; i<level; i++) {
                Node<T> current = toVisit.poll();
                list.add(current);
                if (current.left != null) toVisit.add(current.left);
                if (current.right != null) toVisit.add(current.right);
            }
            result.add(list);
        }
        return result;
    }

    // less space
    public <T> List<LinkedList<Node<T>>> listOfDepths2(Node<T> root) {
        if (root == null) return null;
        List<LinkedList<Node<T>>> result = new LinkedList<>();
        LinkedList<Node<T>> current = new LinkedList<>();
        current.add(root);

        // do a BFS traversal
        while (!current.isEmpty()) {
            result.add(current); // add previous level to result
            LinkedList<Node<T>> parents = current;
            current = new LinkedList<>();
            for (Node<T> parent : parents) {
                if (parent.left != null) current.add(parent.left);
                if (parent.right != null) current.add(parent.right);
            }
        }
        return result;
    }

    // recursive
    public <T> List<LinkedList<Node<T>>> listOfDepths3(Node<T> root) {
        if (root == null) return null;

        List<LinkedList<Node<T>>> result = new ArrayList<>();
        listOfDepths3Helper(root, 0, result);
        return result;
    }

    public <T> void listOfDepths3Helper(Node<T> root, int level, List<LinkedList<Node<T>>> result) {
        if (root == null) return;

        LinkedList<Node<T>> list = null;
        if (result.size() == level) {
            list = new LinkedList<>();
            result.add(list);
        } else {
            list = result.get(level);
        }
        list.add(root);
        listOfDepths3Helper(root.left, level+1, result);
        listOfDepths3Helper(root.right, level+1, result);
    }

    /**
     * CTCI 4.4: Check Balanced: Implement a function to check if a binary tree is balanced.
     * For the purpose of this question, a balanced tree is defined to be a tree such that the
     * heights of the two subtrees of any node never differ by more than one.
     */
    public <T> boolean checkBalanced(Node<T> root) {
        if (root == null) return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    public <T> int getHeight(Node<T> root) {
        if (root == null) return 0;

        int left = getHeight(root.left);
        if (left == -1) return -1;
        int right = getHeight(root.right);
        if (right == -1) return -1;

        // with this, the whole subtree's height is not calculated
        // we return right after diff > 1 and propagate it above
        // actual height is not important, rather it being >1 is important
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    /**
     * CTCI 4.5: Validate BST: Implement a function to check if a binary tree is a binary search tree.
     */
    public boolean validateBst(Node<Integer> root) {
        return validateBstHelper(root, null, null);
    }

    public boolean validateBstHelper(Node<Integer> root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.data < min) || (max != null && root.data > max)) return false;
        // left subtree < root < right subtree
        return validateBstHelper(root.left, min, root.data) && validateBstHelper(root.right, root.data, max);
    }

    /**
     * CTCI 4.6: Successor: Write an algorithm to find the "next" node (i.e., in-order successor)
     * of a given node in a binary search tree.
     */
    public <T> Node<T> findSuccessor(Node<T> root) {
        if (root == null) return null;
        while (root.left != null) root = root.left;
        return root;
    }

    /**
     * CTCI 4.8: First Common Ancestor: Design an algorithm and write code to find the first
     * common ancestor of two nodes in a binary tree.
     */
    public <T> Node<T> lowestCommonAncestor(Node<T> root, Node<T> p, Node<T> q) {
        if (root == null || !contains(root, p) || !contains(root, q)) return null;
        return lowestCommonAncestorHelper(root, p, q);
    }

    public <T> Node<T> lowestCommonAncestorHelper(Node<T> root, Node<T> p, Node<T> q) {
        if (root == null || root == p || root == q) return root;

        boolean isPInLeft = contains(root.left, p);
        boolean isQInLeft = contains(root.left, q);
        // when p & q are not on the same side, means current is the LCA
        if (isPInLeft != isQInLeft) return root;

        // p & q are on the same side, find in the next subtree on the child side
        Node<T> childSide = isPInLeft ? root.left : root.right;
        return lowestCommonAncestor(childSide, p, q);
    }

    public <T> boolean contains(Node<T> root, Node<T> node) {
        if (root == null) return false;
        if (root == node) return true;
        return (contains(root.left, node) || contains(root.right, node));
    }
}

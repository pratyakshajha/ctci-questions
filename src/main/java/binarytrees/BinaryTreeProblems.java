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

    /**
     * CTCI 4.9: BST Sequences: A binary search tree was created by traversing through an array from left to right
     * and inserting each element. Given a binary search tree with distinct elements, print all possible arrays that
     * could have led to this tree.
     */
    public <T> List<List<T>> bstSequences(Node<T> root) {
        List<List<T>> result = new ArrayList<>();
        if (root == null) {
            result.add(new ArrayList<>());
            return result;
        }

        List<T> prefix = new ArrayList<>();
        prefix.add(root.data);

        List<List<T>> leftSequence = bstSequences(root.left);
        List<List<T>> rightSequence = bstSequences(root.right);

        for (List<T> left : leftSequence) {
            for (List<T> right : rightSequence) {
                List<List<T>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    public <T> void weaveLists(List<T> first, List<T> second,
                           List<List<T>> results, List<T> prefix) {
        // if one list is empty, add the other lists to a copy of prefix
        if (first.isEmpty() || second.isEmpty()) {
            List<T> result = new ArrayList<>(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        // take the head of 'first', add to prefix, and recurse
        T headFirst = first.remove(0);
        prefix.add(headFirst);
        weaveLists(first, second, results, prefix);
        // backtrack
        prefix.remove(prefix.size() - 1);
        first.add(0, headFirst);

        //take the head of 'second', add to prefix, and recurse
        T headSecond = second.remove(0);
        prefix.add(headSecond);
        weaveLists(first, second, results, prefix);
        // backtrack
        prefix.remove(prefix.size() - 1);
        second.add(0, headSecond);
    }

    /**
     * CTCI 4.10: Check Subtree: T1 and T2 are two very large binary trees, with T1 much bigger than T2.
     * Create an algorithm to determine if T2 is a subtree of T1. A tree T2 is a subtree of T1 if there exists
     * a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off the tree at node n,
     * the two trees would be identical.
     */
    public <T> boolean checkSubtree(Node<T> root1, Node<T> root2) {
        if (root2 == null) return true; // null tree is a subtree
        if (root1 == null) return false;

        // found the root of T2 in T1, match if subtree of T1 == T2
        if (root1.data == root2.data)
            return matchTree(root1, root2);
        // search in left and right subtrees of T1
        return checkSubtree(root1.left, root2) || checkSubtree(root1.right, root2);
    }

    public <T> boolean matchTree(Node<T> root1, Node<T> root2) {
        if (root1 == null && root2 == null) return true;
        // only one of T1 and T2 is null, hence unequal
        if (root1 == null || root2 == null) return false;
        // data is not equal
        if (root1.data != root2.data) return false;
        // validate the left and right subtrees
        return matchTree(root1.left, root2.left) && matchTree(root1.right, root2.right);
    }

    /**
     * CTCI 4.12: Paths with Sum: You are given a binary tree in which each node contains an integer value
     * (which might be positive or negative). Design an algorithm to count the number of paths that sum
     * to a given value. The path does not need to start or end at the root or a leaf, but it must go
     * downwards (traveling only from parent nodes to child nodes).
     */
    public int pathSum(Node<Integer> root, int targetSum) {
        if (root == null) return 0;
        return pathSumFromNode(root, targetSum, 0)
                + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    public int pathSumFromNode(Node<Integer> root, int targetSum, int currentSum) {
        if (root == null) return 0;
        currentSum += root.data;

        int totalPaths = 0;
        if (currentSum == targetSum) totalPaths++;
        totalPaths += pathSumFromNode(root.left, targetSum, currentSum);
        totalPaths += pathSumFromNode(root.right, targetSum, currentSum);
        return totalPaths;
    }

}

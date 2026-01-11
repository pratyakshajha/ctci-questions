package binarytrees;

public class BinaryTreeProblems {

    /**
     * CTCI 4.8: First Common Ancestor: Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
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

class LinkedListInBinaryTree{

    public boolean isSubPath(ListNode head, TreeNode root) {

        if (root == null)
            return false;

        // Try starting the linked list from current tree node
        if (isMatch(head, root))
            return true;

        // Try in left and right subtree
        return isSubPath(head, root.left) ||
               isSubPath(head, root.right);
    }

    private boolean isMatch(ListNode head, TreeNode root) {

        // Linked list completely matched
        if (head == null)
            return true;

        // Tree ended before linked list
        if (root == null)
            return false;

        // Values don't match
        if (head.val != root.val)
            return false;

        // Continue only downward
        return isMatch(head.next, root.left) ||
               isMatch(head.next, root.right);
    }
}

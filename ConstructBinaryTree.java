class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder elements and their indexes
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return construct(preorder, 0, inorder.length - 1);
    }

    public TreeNode construct(int[] preorder, int left, int right) {

        if(left > right) {
            return null;
        }

        // First element in preorder is root
        int rootValue = preorder[preIndex++];

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int index = map.get(rootValue);

        // Construct left subtree
        root.left = construct(preorder, left, index - 1);

        // Construct right subtree
        root.right = construct(preorder, index + 1, right);

        return root;
    }
}

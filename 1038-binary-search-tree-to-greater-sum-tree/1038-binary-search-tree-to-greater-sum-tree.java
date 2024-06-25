/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private int prefix = 0;

    public TreeNode bstToGst(TreeNode root) {
        reversedInorder(root);
        return root;
    }

    private void reversedInorder(TreeNode root) {
        if (root == null) {
            return;
        }

        reversedInorder(root.right);

        root.val += prefix;
        prefix = root.val;

        reversedInorder(root.left);
    }

    public static void main(String[] args) {
        // Example to test the function
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        Solution sol = new Solution();
        TreeNode newRoot = sol.bstToGst(root);
        
        // Add code to print or verify the result if necessary
    }
}
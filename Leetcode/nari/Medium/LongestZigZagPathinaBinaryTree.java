// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
// title : 1372. Longest ZigZag Path in a Binary Tree
// time taken : 

public class LongestZigZagPathinaBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int max = 0;

        public int longestZigZag(TreeNode root) {
            backtracking(root, 0, 0);

            return max;
        }

        // check == 0인 경우, root node
        // check == 1인 경우, 왼쪽에서 내려온 node
        // check == 2인 경우, 오른쪽에서 내려온 node
        private void backtracking(TreeNode node, int check, int cnt) {
            max = Math.max(max, cnt);
            
            if(node == null) return;

            if(check == 0) {
                if(node.left != null) backtracking(node.left, 1, 1);
                if(node.right != null) backtracking(node.right, 2, 1);
            }
            else if(check == 1) {
                if(node.left != null) backtracking(node.left, 1, 1);
                if(node.right != null) backtracking(node.right, 2, cnt+1);
            }
            else {
                if(node.left != null) backtracking(node.left, 1, cnt+1);
                if(node.right != null) backtracking(node.right, 2, 1);
            }
        }
    }
}

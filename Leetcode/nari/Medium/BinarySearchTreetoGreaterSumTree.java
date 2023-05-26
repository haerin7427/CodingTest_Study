// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
// title : 1038. Binary Search Tree to Greater Sum Tree
// time taken : 33 m 38 s

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

public class BinarySearchTreetoGreaterSumTree {
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

    // 테스트케이스 실패...
    class Solution1 {
        int sum = 0;

        public TreeNode bstToGst(TreeNode root) {
            TreeNode bst = dfs(root);

            return bst;
        }

        public TreeNode dfs(TreeNode node) {
            TreeNode newNode = new TreeNode();

            // 가장 마지막 노드에 도착한 경우
            if(node.left == null && node.right == null) {
                sum += node.val;

                newNode = new TreeNode(sum);

                return newNode;
            }

            if(node.left == null) {
                TreeNode returnNode = dfs(node.right);
                sum += node.val;
                newNode = new TreeNode(sum, null, returnNode);
            }
            else if(node.right == null) {
                TreeNode returnNode = dfs(node.left);
                sum += node.val;
                newNode = new TreeNode(sum, returnNode, null);
            }
            else {
                TreeNode returnNode1 = dfs(node.right);
                sum += node.val;
                int num = sum;
                TreeNode returnNode2 = dfs(node.left);

                newNode = new TreeNode(num, returnNode2, returnNode1);
            }

            return newNode;
        }
    }

    class Solution2 {
        int sum = 0;

        public TreeNode bstToGst(TreeNode root) {
            if (root != null) {
                bstToGst(root.right);

                sum += root.val;
                root.val = sum;

                bstToGst(root.left);
            }

            return root;
        }
    }
}

// https://leetcode.com/problems/validate-binary-search-tree/
// title : 98. Validate Binary Search Tree
// time taken : 42 m 29 s

public class ValidateBinarySearchTree {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            // Node.val의 값 구간이 Integer.MIN_VALUE, Integer.MAX_VALUE 값보다 크기때문에 
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean dfs(TreeNode node, long minVal, long maxVal) {
            if(node == null) return true;

            if(maxVal <= node.val || node.val <= minVal) return false;

            // 왼쪽 노드 && 오른쪽 노드
            return dfs(node.left, minVal, node.val) && dfs(node.right, node.val, maxVal);
        }
    }
}

// https://leetcode.com/problems/binary-tree-paths/
// title : 257. Binary Tree Paths
// time taken : 

public class BinaryTreePaths {
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
        List<String> list = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            dfs(root, new StringBuilder());

            return list;
        }

        private void dfs(TreeNode root, StringBuilder sb) {
            StringBuilder newSb = new StringBuilder(sb);

            if(newSb.length() != 0) newSb.append("->");
            newSb.append(root.val);

            if(root.left == null && root.right == null) {
                list.add(newSb.toString());
                return;
            }

            if(root.left != null) dfs(root.left, newSb);
            if(root.right != null) dfs(root.right, newSb);
        }
    }
}

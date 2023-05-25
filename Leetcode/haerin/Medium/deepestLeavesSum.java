package Leetcode.haerin.Medium;
// https://leetcode.com/problems/deepest-leaves-sum/description/
// title : 1302. Deepest Leaves Sum
// type : DFS
// time : 4m
// Created by haerin on 2023-05-24
public class deepestLeavesSum {
    //  Definition for a binary tree node.
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
        private int deep = 0;
        private int answer = 0;
        public int deepestLeavesSum(TreeNode root) {
            dfs(root, 1);
            return answer;
        }
        public void dfs(TreeNode root, int level){
            if(root.left == null && root.right == null){
                if(deep < level){
                    deep = level;
                    answer = root.val;
                }else if(deep == level){
                    answer += root.val;
                }
            }else{
                if(root.left != null){
                    dfs(root.left, level+1);
                }
                if(root.right != null){
                    dfs(root.right, level+1);
                }
            }
        }
    }
}

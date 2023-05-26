package Leetcode.haerin.Medium;
// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
// title : 1038. Binary Search Tree to Greater Sum Tree
// type : DFS
// time : 10m
// Created by haerin on 2023-05-26
public class binarySearchTreeToGreaterSumTree {
    class Solution {
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
        private int sum = 0;
        public TreeNode bstToGst(TreeNode root) {
            if(root != null) {
                bstToGst(root.right);
                sum += root.val;
                root.val = sum;
                bstToGst(root.left);
            }
            return root;
        }
    }
}

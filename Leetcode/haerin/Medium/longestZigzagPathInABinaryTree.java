package Leetcode.haerin.Medium;
// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
// title : 1372. Longest ZigZag Path in a Binary Tree
// type : 재귀
// time : 10m
// Created by haerin on 2023-06-19
public class longestZigzagPathInABinaryTree {
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
        int answer = 0;
        public int longestZigZag(TreeNode root) {
            if(root.left != null){
                traverse(root.left,true,1);
            }
            if(root.right != null){
                traverse(root.right,false,1);
            }
            return answer;
        }
        public void traverse(TreeNode root,boolean flag,int count){
            if(answer < count){
                answer = count;
            }
            if(root.left != null){
                traverse(root.left, true, !flag?count+1:1);
            }
            if(root.right != null){
                traverse(root.right, false, flag?count+1:1);
            }
        }
    }
}

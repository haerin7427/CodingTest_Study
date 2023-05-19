package Leetcode.haerin.Medium;
// https://leetcode.com/problems/validate-binary-search-tree/submissions/953121729/
// title : 98. Validate Binary Search Tree
// type : dfs
// time : 34m
// Created by haerin on 2023-05-19
public class validateBinarySearchTree {
    //   Definition for a binary tree node.
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
    // 실패 -> limit 범위 조절 실패
    class Solution {
        public boolean isValidBST(TreeNode root) {
            boolean left = true, right = true;
            if(root.left != null){
                left = root.val <= root.left.val ? false : isCorrect(root.left, false, root.val);
            }
            if(root.right != null){
                right = root.val >= root.right.val ? false : isCorrect(root.right, true, root.val);
            }
            return left && right;
        }
    
        private boolean isCorrect(TreeNode node, boolean isRightNode, int parentVal) {
            boolean left = true, right = true;
            if(node.left != null){
                if(node.val <= node.left.val )
                    return false;
                else if(isRightNode && parentVal >= node.left.val){
                    return false;
                }
                else{
                    left = isCorrect(node.left, false, node.val);
                }
                    
            }
            if(node.right != null ){
                if(node.val >= node.right.val){
                    return false;
                }else if(!isRightNode && parentVal <= node.right.val){
                    return false;
                }
                else{
                    right = isCorrect(node.right, true, node.val );
                }
                
            }
            return left && right;
        }
    }
    // 성공
    class Solution2 {
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }
    
        private boolean dfs(TreeNode node, long min, long max) {
            if(node == null) return true;
    
            if(node.val >= max || node.val <= min) return false;
    
            return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
        }
    }
}

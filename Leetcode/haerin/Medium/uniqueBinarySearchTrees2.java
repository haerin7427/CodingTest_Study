package Leetcode.haerin.Medium;
// https://leetcode.com/problems/unique-binary-search-trees-ii/description/
// title : 
// type : ...
// time : 22m
// Created by haerin on 2023-06-01
import java.util.*;
public class uniqueBinarySearchTrees2 {
    
    // Definition for a binary tree node.
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
        public List<TreeNode> generateTrees(int n) {
            return makeSubTrees(1, n);
        }
    
        private List<TreeNode> makeSubTrees(int s, int e) {
            List<TreeNode> ans = new LinkedList<>();
            if(s > e) {
                ans.add(null);
                return ans;
            }
    
            for(int r=s; r<=e; r++){
                List<TreeNode> leftSubtrees = makeSubTrees(s, r - 1);
                List<TreeNode> rightSubtrees = makeSubTrees(r + 1, e);
    
                for(TreeNode left : leftSubtrees) {
                    for(TreeNode right : rightSubtrees) {
                        TreeNode root = new TreeNode(r);
                        root.left = left;
                        root.right = right;
                        ans.add(root);
                    }
                }
            }
            return ans;
        }
    }
}

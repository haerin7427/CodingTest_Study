package Leetcode.haerin.Easy;
// https://leetcode.com/problems/binary-tree-paths/description/
// title : 257. Binary Tree Paths
// type : DFS
// tiem : ...
// created by haerin on 2023-05-28
import java.util.*;
public class binaryTreePaths {
    
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
    class Solution {
        private List<Integer> tmp = new ArrayList<>();
        private List<String> answer = new ArrayList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            dfs(root);
            return answer;
        }
    
        private void dfs(TreeNode node) {
            if(node == null) return;
            tmp.add(node.val);
            if(node.left == null && node.right == null){
                makeString();
            }else{
                dfs(node.left);
                dfs(node.right);
            }
            tmp.remove(tmp.size()-1);
        }
    
        private void makeString() {
            StringBuilder sb = new StringBuilder();
            for(int num : tmp){
                sb.append(num+"->");
            }
            sb.delete(sb.length()-2, sb.length());
            answer.add(sb.toString());
        }
    }
}

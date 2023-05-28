package Leetcode.haerin.Medium;
// https://leetcode.com/problems/all-possible-full-binary-trees/description/
// title : 894. All Possible Full Binary Trees
// type : DP
// time : 30m
// Created by haerin on 2023-05-28
import java.util.*;
public class allPossibleFullBinaryTrees {
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
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();
    private int DEFAULT_NODE_VALUE = 0;
    public List<TreeNode> allPossibleFBT(int n) {
        return dp(n);
    }

    private List<TreeNode> dp(int n) {
        if(n % 2 == 0){
            memo.put(n, Collections.emptyList());
            return memo.get(n);
        }
        if(n == 1) {
            memo.put(n, List.of(new TreeNode(DEFAULT_NODE_VALUE, null, null)));
            return memo.get(n);
        }

        if(!memo.containsKey(n)){
            List<TreeNode> trees = new ArrayList<>();
            for(int leftCnt = 0; leftCnt<n-1; leftCnt++){
                int rightCnt = n - 1 - leftCnt;
                for(TreeNode left : dp(leftCnt)){
                    for(TreeNode right : dp(rightCnt)){
                        TreeNode newNode = new TreeNode(DEFAULT_NODE_VALUE, left, right);
                        trees.add(newNode);
                    }
                }
            }
            memo.put(n, trees);
        }
        return memo.get(n);
    }
}
}

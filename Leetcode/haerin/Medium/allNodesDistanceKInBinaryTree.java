package Leetcode.haerin.Medium;
// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
// title : 863. All Nodes Distance K in Binary Tree
// type : DFS + Graph
// time : 30m + ..
// created by haerin on 2023-07-12
import java.util.*;
class Solution {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private boolean[] isVisited = new boolean[501];
    private List<Integer> ans = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        makeGraph(root, -1);
        findDistanceK(target.val, 0, k);
        return ans;
    }

    private void findDistanceK(int num, int d, int k) {
        isVisited[num] = true;
        if(d == k) {
            ans.add(num);
        }else {
            for(int value : graph.get(num)){
                if(isVisited[value]) continue;
                findDistanceK(value, d+1, k);
            }
        }
    }

    private void makeGraph(TreeNode node, Integer parent) {
        if(node == null) return;
        graph.put(node.val, new ArrayList<>());
        if(parent >= 0) {
            graph.get(node.val).add(parent);
            graph.get(parent).add(node.val);
        }
        makeGraph(node.left, node.val);
        makeGraph(node.right, node.val);
    }
}
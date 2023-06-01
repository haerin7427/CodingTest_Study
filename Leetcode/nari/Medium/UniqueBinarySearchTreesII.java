// https://leetcode.com/problems/unique-binary-search-trees-ii/
// title : 95. Unique Binary Search Trees II
// time taken : 

import java.util.*;

public class UniqueBinarySearchTreesII {
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
            return makingTrees(1, n);
        }

        private List<TreeNode> makingTrees(int start, int end) {
            List<TreeNode> list = new ArrayList<>();

            if(start > end) {
                list.add(null);

                return list;
            }

            for(int i=start;i<=end;i++) {
                List<TreeNode> left = makingTrees(start, i-1);
                List<TreeNode> right = makingTrees(i+1, end);

                for(TreeNode l : left) {
                    for(TreeNode r : right) {
                        TreeNode root = new TreeNode(i, l, r);

                        list.add(root);
                    }
                }
            }

            return list;
        }
    }
}

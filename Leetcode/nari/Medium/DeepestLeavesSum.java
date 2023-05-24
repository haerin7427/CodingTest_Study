// https://leetcode.com/problems/deepest-leaves-sum/
// title : 1302. Deepest Leaves Sum
// time taken : 20 m 4 s + 20 m (늦게 start...)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.*;

public class DeepestLeavesSum {
    class Solution {
        public int deepestLeavesSum(TreeNode root) {
            int sum = 0, before = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<Integer> depth = new LinkedList<>();

            queue.add(root);
            depth.add(1);

            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                int curDepth = depth.poll();

                if(before != curDepth) sum = 0;

                if(node.left == null && node.right == null) {
                    before = curDepth;
                    sum += node.val;
                    continue;
                }

                if(node.left == null) {
                    queue.add(node.right);
                    depth.add(curDepth + 1);
                }
                else if(node.right == null) {
                    queue.add(node.left);
                    depth.add(curDepth + 1);
                }
                else {
                    queue.add(node.left);
                    depth.add(curDepth + 1);
                    queue.add(node.right);
                    depth.add(curDepth + 1);
                }

                sum = 0;
                before = curDepth;
            }

            return sum;
        }
    }
}

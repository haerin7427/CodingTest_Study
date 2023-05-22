// https://leetcode.com/problems/all-possible-full-binary-trees/
// 894. All Possible Full Binary Trees
// time taken : 18 m 8 s

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

public class AllPossibleFullBinaryTrees {
    class Solution {
        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> list = new ArrayList<>();

            // 짝수인 경우 -> 제외
            if(n%2 == 0) return list;

            if(n == 1) {
                list.add(new TreeNode(0));

                return list;
            }

            // 왼쪽, 오른쪽 둘다 넣어주기 때문에 2씩 증가
            for(int i=1;i<n;i+=2) {
                // 제일 왼쪽, 제일 오른쪽
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(n-i-1);

                for(TreeNode l : left) {
                    for(TreeNode r : right) {
                        list.add(new TreeNode(0, l, r));
                    }
                }
            }

            return list;
        }
    }
}

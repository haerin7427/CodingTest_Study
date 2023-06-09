// https://leetcode.com/problems/subsets/
// title : 78. Subsets
// time taken : 

public class Subsets {
    class Solution {
        List<List<Integer>> list = new ArrayList<>();
        int[] Nums;
        int len;

        public List<List<Integer>> subsets(int[] nums) {
            Nums = nums;
            len = nums.length;

            for(int i=0;i<=len;i++) {
                backtracking(i, new ArrayList<>(), 0);
            }
            
            return list;
        }

        private void backtracking(int limit, List<Integer> subList, int idx) {
            if(limit == subList.size()) {
                list.add(new ArrayList<>(subList));
                return;
            }

            for(int i=idx;i<len;i++) {
                subList.add(Nums[i]);
                backtracking(limit, subList, i+1);
                subList.remove(subList.size()-1);
            }
        }
    }
}

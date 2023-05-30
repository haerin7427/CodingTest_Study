// https://leetcode.com/problems/sum-of-all-subset-xor-totals/
// title : 1863. Sum of All Subset XOR Totals
// time taken : 

public class SumofAllSubsetXORTotals {
    class Solution {
        int total = 0;
        int[] Nums;
        int len = 0;

        public int subsetXORSum(int[] nums) {
            Nums = nums;
            len = nums.length;

            for(int i=1;i<=len;i++) {
                backtracking(i, 0, new ArrayList<>());
            }

            return total;
        }

        private void backtracking(int limit, int idx, ArrayList<Integer> list) {
            int size = list.size();

            if(size == limit) {
                int sum = list.get(0);

                for(int i=1;i<size;i++) {
                    sum ^= list.get(i);
                }

                total += sum;
                return;
            }

            for(int i=idx;i<len;i++) {
                ArrayList<Integer> newArr = new ArrayList<>(list);

                newArr.add(Nums[i]);

                backtracking(limit, i+1, newArr);
            }
        }
    }
}

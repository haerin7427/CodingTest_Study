package Leetcode.haerin.Medium;
// https://leetcode.com/problems/permutations/description/
// title : 46. Permutations
// type : backtacking
// time : 5m
// created by haerin on 2023-06-07
import java.util.*;;
public class permutations {
    class Solution {
        private List<List<Integer>> answer = new ArrayList<>();
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> tmp = new ArrayList<>();
            boolean[] isUsed = new boolean[nums.length];
            getAllPermutations(nums, isUsed, tmp);
            return answer;
        }
    
        public void getAllPermutations(int[] nums, boolean[] isUsed, List<Integer> tmp) {
            if(tmp.size() == nums.length) {
                answer.add(new ArrayList<>(tmp));
                return;
            }
            for(int i=0; i<nums.length; i++) {
                if(isUsed[i]) continue;
    
                isUsed[i] = true;
                tmp.add(nums[i]);
                getAllPermutations(nums, isUsed, tmp);
                isUsed[i] = false;
                tmp.remove(new Integer(nums[i]));
            }
        }
    }
}

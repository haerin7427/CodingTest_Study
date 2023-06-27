package Leetcode.haerin.Medium;
// https://leetcode.com/problems/permutations-ii/
// title : 47. Permutations II
// type : Backtracking
// time : ...
// created by haerin on 2023-06-27
import java.util.*;
public class permutations2 {
    class Solution {
        int N;
        boolean[] isUsed;
        List<List<Integer>> answer = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            N = nums.length;
            isUsed = new boolean[N];
            permutations2(new ArrayList<>(), nums);
            return answer;
        }
    
        private void permutations2(List<Integer> tmp, int[] nums) {
            if(tmp.size() == N) {
                if(!answer.contains(tmp))
                    answer.add(new ArrayList<>(tmp));
                return ;
            }
            for(int i=0; i<N; i++){
                if(isUsed[i]) continue;
                isUsed[i] = true;
                tmp.add(nums[i]);
                permutations2(tmp, nums);
                isUsed[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}

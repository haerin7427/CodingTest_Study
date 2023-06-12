package Leetcode.haerin.Medium;
// https://leetcode.com/problems/subsets/description/
// title : 78. Subsets
// type : backtracking
// time : 6m
// created by haerin on 2023-06-09
import java.util.*;
public class subsets {
    class Solution {
        private List<List<Integer>> answer = new ArrayList<>();
        public List<List<Integer>> subsets(int[] nums) {
            makeSubset(new ArrayList<>(), nums, 0);
            return answer;
        }
    
        private void makeSubset(List<Integer> list, int[] nums, int idx) {
            answer.add(new ArrayList<>(list));
    
            for(int i=idx; i<nums.length; i++){
                if(list.contains(nums[i])) continue;
                list.add(nums[i]);
                makeSubset(list, nums, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}

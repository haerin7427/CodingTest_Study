package Leetcode.haerin.Medium;
// https://leetcode.com/problems/combination-sum-ii/description/
// title : 40. Combination Sum II
// type : Backtracking
// time : 16m
// Created by haerin on 2023-06-01
import java.util.*;
public class combinationSum2 {
    class Solution {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            getSum(candidates, 0, target, 0);
            return answer;
        }
    
        private void getSum(int[] candidates, int sum, int target, int idx) {
            if(sum == target) {
                Collections.sort(list);
                if(!answer.contains(list)){
                    answer.add(new ArrayList<>(list));
                }
                return ;
            }
            for(int i = idx; i<candidates.length; i++) {
                if(i!=idx && candidates[i]==candidates[i-1]) continue;
                if(sum + candidates[i] > target) break;
                list.add(candidates[i]);
                getSum(candidates, sum + candidates[i], target, i+1);
                list.remove(new Integer(candidates[i]));
            }
        }
    }
}

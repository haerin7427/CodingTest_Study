package Leetcode.haerin.Medium;
// https://leetcode.com/problems/combination-sum/description/
// title : 39. Combination Sum
// type : backtraking
// time : 25m
// created by haerin on 2023-05-31
import java.util.*;
public class combinationSum {
    class Solution {
        private List<List<Integer>> answer = new ArrayList<>();
        private List<Integer> list = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            int min = candidates[0];
            for(int i=1; i<=target / min; i++){
                find(candidates, target, i, 0);
            }
            return answer;
        }
        private void find (int[] candidates, int target, int len, int sum){
            if(list.size() == len) {
                if(sum == target){
                    Collections.sort(list);
                    if(!answer.contains(list)){
                        answer.add(new ArrayList<>(list));
                    }
                        
                }
                return;
            }
            for(int i=0; i<candidates.length; i++){
                if(sum + candidates[i] > target){
                    break;
                }
                list.add(candidates[i]);
                sum += candidates[i];
                find(candidates, target, len, sum);
                list.remove(new Integer(candidates[i]));
                sum -= candidates[i];
            }
    
        }
    }
}

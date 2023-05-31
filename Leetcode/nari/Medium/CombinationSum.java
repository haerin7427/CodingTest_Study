// https://leetcode.com/problems/combination-sum/
// title : 39. Combination Sum
// time taken : 

import java.util.*;

public class CombinationSum {
    class Solution {
        Set<List<Integer>> list = new HashSet<>();
        int[] Candidates;
        int Target;
        int len = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Candidates = candidates;
            Target = target;
            len = candidates.length;

            backtracking(new ArrayList<>(), 0);

            return new ArrayList<>(list);
        }

        private void backtracking(ArrayList<Integer> subList, int sum) {
            if(sum > Target) return;

            if(sum == Target) {
                ArrayList<Integer> newArr = new ArrayList<>(subList);

                Collections.sort(newArr);

                list.add(newArr);

                return;
            }

            for(int i=0;i<len;i++) {
                subList.add(Candidates[i]);
                sum += Candidates[i];

                backtracking(subList, sum);

                subList.remove(subList.size()-1);
                sum -= Candidates[i];
            }
        }
    }
}

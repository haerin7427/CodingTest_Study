// https://leetcode.com/problems/combination-sum-ii/
// title : 40. Combination Sum II
// time taken : 33 m 38 s

import java.util.*;

public class CombinationSumII {
    // Time Limit Exceeded
    class Solution1 {
        Set<List<Integer>> set = new HashSet<>();
        int[] Candidates;
        int Target;
        int len = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);

            Candidates = candidates;
            Target = target;
            len = candidates.length;

            backtracking(new ArrayList<>(), 0, 0);

            return new ArrayList<>(set);
        }

        private void backtracking(ArrayList<Integer> list, int sum, int idx) {
            if(sum == Target) {
                set.add(new ArrayList<>(list));

                return;
            }

            for(int i=idx;i<len;i++) {
                if(sum + Candidates[i] > Target) break;

                list.add(Candidates[i]);
                sum += Candidates[i];

                backtracking(list, sum, i+1);

                list.remove(list.size()-1);
                sum -= Candidates[i];
            }
        }
    }

    class Solution2 {
        List<List<Integer>> list = new ArrayList<>();
        int[] Candidates;
        int len = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);

            Candidates = candidates;
            len = candidates.length;

            backtracking(new ArrayList<>(), target, 0);

            return list;
        }

        private void backtracking(ArrayList<Integer> subList, int target, int idx) {
            if(target == 0) {
                list.add(new ArrayList<>(subList));
                return;
            }

            for(int i=idx;i<len;i++) {
                if(i != idx && Candidates[i] == Candidates[i-1]) continue;
                if(Candidates[i] > target) break;

                subList.add(Candidates[i]);

                backtracking(subList, target-Candidates[i], i+1);

                subList.remove(subList.size()-1);
            }
        }
    }
}

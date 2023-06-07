// https://leetcode.com/problems/permutations/
// title : 46. Permutations
// time taken : 

import java.util.*;

public class Permutations {
    class Solution {
        List<List<Integer>> list = new ArrayList<>();
        int[] Nums;
        int len;

        public List<List<Integer>> permute(int[] nums) {
            Nums = nums;
            len = nums.length;

            backtracking(new ArrayList<>());
            
            return list;
        }

        private void backtracking(ArrayList<Integer> subList) {
            if(subList.size() == len) {
                list.add(new ArrayList<>(subList));
                return;
            }

            for(int i=0;i<len;i++) {
                // nums의 int 값들은 unique하다는 조건 존재
                if(subList.contains(Nums[i])) continue;

                subList.add(Nums[i]);
                backtracking(subList);
                subList.remove(subList.size()-1);
            }
        }
    }
}

// https://leetcode.com/problems/permutations-ii/
// title : 47. Permutations II
// time taken : 

public class PermutationsII {
    class Solution {
        Set<List<Integer>> set = new HashSet<>();
        int[] Nums;
        int len = 0;
        boolean[] visited;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Nums = nums;
            len = nums.length;
            visited = new boolean[len];

            backtracking(new ArrayList<>());

            return new ArrayList<>(set);
        }

        private void backtracking(List<Integer> list) {
            if(list.size() == len) {
                set.add(new ArrayList<>(list));
                return;
            }

            for(int i=0;i<len;i++) {
                if(visited[i]) continue;

                list.add(Nums[i]);
                visited[i] = true;

                backtracking(list);

                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}

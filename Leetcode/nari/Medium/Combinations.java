// https://leetcode.com/problems/combinations/
// title : 77. Combinations
// time taken : 

import java.util.*;

public class Combinations {
    class Solution {
        Set<List<Integer>> set = new HashSet<>();
        int N;
        int K;
        boolean[] visited;

        public List<List<Integer>> combine(int n, int k) {
            N = n;
            K = k;
            visited = new boolean[N+1];

            for(int i=1;i<=n;i++) {
                List<Integer> list = new ArrayList<>();

                list.add(i);
                visited[i] = true;

                backtracking(list, i+1);

                list.remove(list.size()-1);
                visited[i] = false;
            }

            return new ArrayList<>(set);
        }

        private void backtracking(List<Integer> list, int idx) {
            if(list.size() == K) {
                Collections.sort(list);
                set.add(new ArrayList<>(list));
                return;
            }

            for(int i=idx;i<=N;i++) {
                if(visited[i]) continue;

                list.add(i);
                visited[i] = true;

                backtracking(list, i+1);

                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}

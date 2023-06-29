package Leetcode.haerin.Medium;
// https://leetcode.com/problems/combinations/
// title : 77. Combinations
// type : Backtracking
// time : ...
// created by haerin on 2023-06-27
import java.util.*;
public class combinations {
    class Solution {
        List<List<Integer>> answer = new ArrayList<>();
        int N;
        int K;
        public List<List<Integer>> combine(int n, int k) {
            N = n; K = k;
            combinations(1, new ArrayList<Integer>());
            return answer;
        }
    
        private void combinations(int index, List<Integer> tmp) {
            if(tmp.size() == K) {
                answer.add(new ArrayList<>(tmp));
                return ;
            }
    
            for(int i = index; i<=N; i++) {
                tmp.add(i);
                combinations(i+1, tmp);
                tmp.remove(new Integer(i));
            }
        }
    }
}

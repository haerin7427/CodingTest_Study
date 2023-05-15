package Leetcode.haerin.Medium;
// https://leetcode.com/problems/generate-parentheses/
// 22. Generate Parentheses
// time : 23m
// type : DP
// Created by haerin on 2023-05-15
import java.util.*;
public class generateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<Set<String>> answer = new ArrayList<>();
            answer.add(new HashSet<>());
            answer.get(0).add("()");
            answer.add(new HashSet<>());
            answer.get(1).add("()");
    
            for(int i=2; i<=n; i++){
                Set<String> set = new HashSet<>();
                for(String s : answer.get(i-1)){
                    set.add("("+s+")");
                }
                
                for(int j=1; j<=i/2; j++){
                    int h = i-j;
                    for(String a : answer.get(j)){
                        for(String b : answer.get(h)){
                            set.add(a+b);
                            set.add(b+a);
                        }
                    }
                }
                answer.add(set);
            }

            List<String> ans = new ArrayList<>(answer.get(n));
            Collections.sort(ans);
            return ans;
        }
    }
}

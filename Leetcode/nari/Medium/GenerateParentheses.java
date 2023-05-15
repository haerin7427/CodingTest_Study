// https://leetcode.com/problems/generate-parentheses/
// title : 22. Generate Parentheses
// time taken : 30 m 47 s

import java.util.*;

public class GenerateParentheses {
    // dp로 풀려다가 괄호 조합하는 과정에서 실패
    class Solution {
        List<String> list = new ArrayList<>();
        int N = 0;
        
        public List<String> generateParenthesis(int n) {
            N = n;

            backtracking(new StringBuilder(""), 0, 0);

            return list;
        }

        public void backtracking(StringBuilder s, int open, int close) {
            // 열린 괄호, 닫힌 괄호가 각각 N개만큼 존재해야기 때문에
            if(s.length() == N*2) {
                list.add(s.toString());

                return;
            }

            // 열린 괄호 N개 까지만 
            if(open < N) {
                StringBuilder sb = new StringBuilder(s);
                sb.append("(");

                backtracking(sb, open+1, close);
            }

            // 닫힌 괄호는 열린 괄호 갯수만큼만
            if(close < open) {
                StringBuilder sb = new StringBuilder(s);
                sb.append(")");

                backtracking(sb, open, close+1);
            }
        }
    }
}
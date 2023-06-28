package Leetcode.haerin.Medium;
// https://leetcode.com/problems/letter-case-permutation/description/
// title : 784. Letter Case Permutation
// type : backtracking
// time : 20m
// created by haerin on 2023-06-28
import java.util.*;
public class letterCasePermutation {
    class Solution {
        List<String> answer = new ArrayList<>();
        public List<String> letterCasePermutation(String s) {
            backtracking(0, s, new StringBuilder());
            return answer;
        }
    
        private void backtracking(int idx, String s, StringBuilder sb) {
            if(sb.length() == s.length()) {
                answer.add(new String(sb.toString()));
                return;
            }
    
            char word = s.charAt(idx);
            if(s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z') {
                word -= 32;
                sb.append(word);
                backtracking(idx+1, s, sb);
                sb.deleteCharAt(sb.length()-1);
            }else if(s.charAt(idx) >= 'A' && s.charAt(idx) <= 'Z') {
                word += 32;
                sb.append(word);
                backtracking(idx+1, s, sb);
                sb.deleteCharAt(sb.length()-1);
            }
    
            sb.append(s.charAt(idx));
            backtracking(idx+1, s, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

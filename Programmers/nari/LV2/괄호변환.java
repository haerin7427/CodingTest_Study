// https://school.programmers.co.kr/learn/courses/30/lessons/60058
// title : 괄호 변환

import java.util.*;

public class 괄호변환 {
    class Solution {
        public String solution(String p) {
            return dfs(p);
        }
        
        String dfs(String p) {
            StringBuilder sb = new StringBuilder();
            int cnt = 0, idx = 0;
            
            // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
            if(p.length() == 0) return "";
            
            // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 
            // 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, 
            // v는 빈 문자열이 될 수 있습니다. 
            
            // 균형잡힌 괄호 문자열의 index 찾기
            while(idx < p.length()) {
                char c = p.charAt(idx++);
                
                if(c == '(') cnt++;
                else cnt--;
                
                if(cnt == 0) break;
            }
            
            String u = p.substring(0, idx);
            String v = p.substring(idx, p.length());
            
            // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다. 
            // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다. 
            if(isCorrect(u)) {
                sb.append(u);
                sb.append(dfs(v));
            }
            // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
            else {
                // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
                sb.append("(");
                // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
                sb.append(dfs(v));
                // 4-3. ')'를 다시 붙입니다. 
                sb.append(")");
                
                // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
                for(int i=1;i<u.length()-1;i++) {
                    char c = u.charAt(i);
                    
                    if(c == '(') sb.append(")");
                    else sb.append("(");
                }
            }
            
            return sb.toString();
        }
        
        boolean isCorrect(String p) {
            Stack<Character> s = new Stack<>();
            
            for(int i=0;i<p.length();i++){
                char c = p.charAt(i);
                
                // 여는 괄호일 경우
                if(c == '(') s.add(c);
                else {
                    // 닫는 괄호인데, stack에 여는 괄호가 없으면, 올바른 문자열이 아님
                    if(s.isEmpty()) return false;
                    else s.pop();
                }
            }
            
            return s.isEmpty();
        }
    }
}
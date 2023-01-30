// https://school.programmers.co.kr/learn/courses/30/lessons/140108
// title : 문자열 나누기

public class 문자열나누기 {
    class Solution {
        public int solution(String s) {
            int answer = 0;
            int same = 1, diff = 0;
            char first = s.charAt(0);
            
            for(int i=1;i<s.length();i++) {
                if(first == s.charAt(i)) same++;
                else diff++;
                
                if(same == diff && i < s.length()-1) {
                    answer++;
                    first = s.charAt(i+1);
                    i += 1;
                    same = 1;
                    diff = 0;
                }
            }
            
            return answer+1;
        }
    }
}
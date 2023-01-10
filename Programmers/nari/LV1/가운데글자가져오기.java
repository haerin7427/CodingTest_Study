// https://school.programmers.co.kr/learn/courses/30/lessons/12916
// title : 가운데 글자 가져오기

public class 가운데글자가져오기 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            double doubleMid = (double)s.length()/2;
            int intMid = s.length()/2;
            
            if(doubleMid%1 == 0) answer = Character.toString(s.charAt(intMid-1)) + Character.toString(s.charAt(intMid));
            else answer = Character.toString(s.charAt(intMid));
            
            return answer;
        }
    }
}
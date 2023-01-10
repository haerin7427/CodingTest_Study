// https://school.programmers.co.kr/learn/courses/30/lessons/12903
// title : 가운데 글자 가져오기

public class 가운데글자가져오기 {
    // 테스트 케이스 16개 기준 평균 속도 0.68ms -> 보통 빠른건(9개) 0.04ms 정도, 느린건(7개) 1.40ms 정도
    class Solution1 {
        public String solution(String s) {
            String answer = "";
            double doubleMid = (double)s.length()/2;
            int intMid = s.length()/2;
            
            if(doubleMid%1 == 0) answer = Character.toString(s.charAt(intMid-1)) + Character.toString(s.charAt(intMid));
            else answer = Character.toString(s.charAt(intMid));
            
            return answer;
        }
    }

    // 테스트 케이스 16개 기준 평균 속도 0.02ms
    class Solution2 {
        public String solution(String s) {
            String answer = "";
            double doubleMid = (double)s.length()/2;
            int intMid = s.length()/2;
            
            if(doubleMid%1 == 0) answer = s.substring(intMid-1, intMid+1);
            else answer = s.substring(intMid, intMid+1);
            
            return answer;
        }
    }
}
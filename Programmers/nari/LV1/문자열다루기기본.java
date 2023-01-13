// https://school.programmers.co.kr/learn/courses/30/lessons/12918
// title : 문자열 다루기 기본

public class 문자열다루기기본 {
    // 테스트 케이스 30개 기준 평균 속도 약 0.03ms
    // 자바 예외처리 관련된 항목에서 금기시 되는 풀이 -> 예외는 실제 예외 상황일때만 사용하라
    // 흐름제어를 위해서 예외로 처리하는건 금기시 되는 풀이
    class Solution1 {
        public boolean solution(String s) {
            boolean answer = true;

            if(s.length() != 4 && s.length() != 6) answer = false;
            else {
                try {
                    int a = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    answer = false;
                }
            }
            
            return answer;
        }
    }

    // 테스트 케이스 30개 기준 평균 속도 약 0.10ms
    class Solution2 {
        public boolean solution(String s) {
            if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
            return false;
        }
    }

    // 테스트 케이스 30개 기준 평균 속도 약 0.13ms
    class Solution3 {
        public boolean solution(String s) {
            return (s.length() != 4 && s.length() != 6) || (s.split("[0-9]").length > 0) ? false : true;
        }
    }
}
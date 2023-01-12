// https://school.programmers.co.kr/learn/courses/30/lessons/12925
// title : 문자열을 정수로 바꾸기

public class 문자열을정수로바꾸기 {
    // valueOf() 메소드는 문자열을 변환하여 Integer Object를 리턴
    // parseInt() 메소드는 primitive type인 int를 리턴

    // 테스트 케이스 15개 기준 평균 속도 0.02ms
    class Solution1 {
        public int solution(String s) {
            return Integer.parseInt(s);
        }
    }

    // 테스트 케이스 15개 기준 평균 속도 0.02ms
    class Solution2 {
        public int solution(String s) {
            return Integer.valueOf(s);
        }
    }
}
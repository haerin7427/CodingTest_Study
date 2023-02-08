// https://school.programmers.co.kr/learn/courses/30/lessons/12985
// title : 예상 대진표

public class 예상대진표 {
    class Solution1 {
        public int solution(int n, int a, int b) {
            int answer = 0;

            while(a != b) {
                a = (a + 1) / 2;
                b = (b + 1) / 2;
                answer++;
            }

            return answer;
        }
    }

    class Solution2 {
        public int solution(int n, int a, int b) {
            // (a-1) XOR (b-1) 값을 이진수 문자열로 변환한 길이
            // 예를들어 4과 7이면, 3(11) XOR 6(110)이고 값은 101이 되니까
            // 문자열 길이가 바로 3라운드
            return Integer.toBinaryString((a-1)^(b-1)).length();
        }
    }
}
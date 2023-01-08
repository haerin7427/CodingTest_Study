// https://school.programmers.co.kr/learn/courses/30/lessons/12937
// title : 짝수와 홀수
// time : 1m
public class 짝수와홀수 {
    // testcase 기준 속도 비슷
    class Solution {
        public String solution(int num) {
            return num%2==0 ? "Even" : "Odd";
        }
    }
    class Solution2 {
        public String solution(int num) {
            if(num %2 == 0) {
                return "Even";
            } else {
                return "Odd";
            }
        }
    }
}

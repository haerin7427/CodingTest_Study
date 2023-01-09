// https://school.programmers.co.kr/learn/courses/30/lessons/12934
// title : 정수 제곱근 판별

public class 정수제곱근판별 {
    class Solution {
        public long solution(long n) {
            double sqrt = Math.sqrt(n);
            
            return sqrt%1 == 0 ? (long)Math.pow(sqrt+1, 2) : -1;
        }
    }
}
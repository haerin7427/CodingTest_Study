// https://school.programmers.co.kr/learn/courses/30/lessons/12928
// title : 약수의 합
// time : 1m
// 유형 : 완전탐색
public class 약수의합 {
    class Solution {
        public int solution(int n) {
            int answer = 0;
            for(int i=1; i<= n; i+=1) {
                if(n % i == 0) {
                    answer += i;
                }
            }
            return answer;
        }
    }
}
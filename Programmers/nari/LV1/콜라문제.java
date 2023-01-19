// https://school.programmers.co.kr/learn/courses/30/lessons/132267
// title : 콜라 문제

public class 콜라문제 {
    class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;
            int quotient = 0, remainder = 0;
            
            while(n>1) {
                if(n<a) break;
                
                quotient = n/a;
                remainder = n%a;
                
                answer += b * quotient;
                
                n = b * quotient + remainder;
            }
            
            return answer;
        }
    }
}
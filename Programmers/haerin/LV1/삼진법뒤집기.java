// https://school.programmers.co.kr/learn/courses/30/lessons/68935
// title : 3진법 뒤집기
// time : 15m
// type : ...
// Created by haerin 2023-01-26
public class 삼진법뒤집기 {
    // 0.063ms
    class Solution {
        public int solution(int n) {
            StringBuilder sb = new StringBuilder();
            while(n >= 3) {
                sb.append(n%3);
                n /= 3;
            }
            sb.append(n);
            
            int answer = 0;
            int cnt=sb.length()-1;
            for(int i=0; i<sb.length(); i++){
                int num = Integer.parseInt(sb.toString().substring(i,i+1));
                answer += num * Math.pow(3, cnt--);
            }
            return answer;
        }
    }
    // 0.047ms
    class Solution2 {
        public int solution(int n) {
            StringBuilder sb = new StringBuilder();
            while(n >= 3) {
                sb.append(n%3);
                n /= 3;
            }
            sb.append(n);
            return Integer.parseInt(sb.toString(),3);
        }
    }
}

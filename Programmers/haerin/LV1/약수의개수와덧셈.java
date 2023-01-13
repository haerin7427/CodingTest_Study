// https://school.programmers.co.kr/learn/courses/30/lessons/77884
// title : 약수의 개수와 덧셈
// time : 5m
// 유형 : 계산
// Created by haerin on 2023/01/12
public class 약수의개수와덧셈 {
    class Solution {
        public int solution(int left, int right) {
            int answer = 0;
            for(int i=left; i<=right; i++) {
                if(countNum(i) % 2== 0) {
                    answer += i;
                } else {
                    answer -= i;
                }
            }
            return answer;
        }
        
        private int countNum(int n) {
            int count =0;
            for(int i=1; i<=n; i++) {
                if(n%i == 0) {
                    count += 1;
                }
            }
            return count;
        }
    }
    // solution2가 훨씬 빠름
    class Solution2 {
        public int solution(int left, int right) {
            int answer = 0;
            for(int i=left; i<=right; i++) {
                if(i % Math.sqrt(i) == 0) {
                    answer -= i;
                } else {
                    answer += i;
                }
            }
            return answer;
        }
    }
}

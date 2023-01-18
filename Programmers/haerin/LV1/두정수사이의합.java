// https://school.programmers.co.kr/learn/courses/30/lessons/12912
// title : 두 정수 사이의 합
// time : 3m
// type : 숫자 계산
// Created by haerin on 2023/01/17
public class 두정수사이의합 {
    class Solution {
        public long solution(int a, int b) {
            if(a == b) return a;
            if(a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            
            long answer = 0;
            for(int num = a; num <= b; num+=1) {
                answer += num;
            }
            return answer;
        }
    }
    class Solution2 {
        public long solution(int a, int b) {
            long answer = 0;
            for(int num = Math.min(a,b); num <= Math.max(a,b); num+=1) {
                    answer += num;
            }
           
            return answer;
        }
    }
    class Solution3 {
        public long solution(int a, int b) {
            return sumAtoB(Math.min(a,b), Math.max(a,b));
        }
        public long sumAtoB(long a, long b) {
            return (b-a+1)*(a+b)/2;
            // 등차수열의 합 공식 : 첫째항 a, 마지막 항 b, 등차가 1인 제1항부터 제n항까지의 합을 구할때 n(a+b)/2
        }
    }
}

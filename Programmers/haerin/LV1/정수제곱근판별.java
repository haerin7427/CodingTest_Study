// https://school.programmers.co.kr/learn/courses/30/lessons/12934
// title : 정수제곱근판별
// time : 9m
// Created by haerin on 2023/01/09
public class 정수제곱근판별 {
    class Solution {
        public long solution(long n) {
            double sqrt = Math.sqrt(n);
            if(sqrt == (int) sqrt) 
                return (long) Math.pow((int)sqrt+1, 2);
            
            return -1;
        }
    }

    class Solution2 {
        public long solution(long n) {
            if (Math.pow((int)Math.sqrt(n), 2) == n) {
                return (long) Math.pow(Math.sqrt(n) + 1, 2);
            }
    
            return -1;
        }
    }
}

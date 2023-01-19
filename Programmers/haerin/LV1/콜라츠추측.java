// https://school.programmers.co.kr/learn/courses/30/lessons/12943
// title : 콜라츠 추측
// time : 10m
// type : 숫자
// Created by haerin on 2023/01/19
public class 콜라츠추측 {
    // 0.0362ms
    class Solution {
        public int solution(int num) {
            int answer = 0;
            long n = num;
            while(n != 1) {
                if(answer > 499) {
                    return -1;
                }
                answer += 1;
                if(n%2 == 0) {
                    n /= 2;
                }else {
                    n = n*3+1;
                }
            }
            return answer;
        }
    }
    // 0.0318ms
    class Solution2 {
        public int solution(int num) {
            long n = (long)num;
            for(int i=0; i<500; i++) {
                if(n == 1) {
                    return i; 
                } 
                n = n%2==0 ? n/2 : n*3+1;
            }
            return -1;
        }
    }
}

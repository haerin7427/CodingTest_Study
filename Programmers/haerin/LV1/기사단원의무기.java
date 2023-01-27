// https://school.programmers.co.kr/learn/courses/30/lessons/136798
// title : 기사단원의 무기
// time : 15m
// type : ...
// Created by haerin on 2023-01-27
public class 기사단원의무기 {
    class Solution {
        public int solution(int number, int limit, int power) {
            int answer = 0;
            for(int num=1; num<=number; num++) {
                int cnt = countDivisor(num);
                
                if(cnt > limit) {
                    answer += power;
                }else {
                    answer += cnt;
                }
            }
            return answer;
        }
        
        public int countDivisor(int num) {
            int count = 0;
            for(int i=1; i<Math.sqrt(num); i++) {
                if(num % i == 0) {
                    count+=2;
                }
            }
            if(Math.sqrt(num) == (int)Math.sqrt(num)) {
                count +=1;
            }
            // if(Math.sqrt(n)%1==0){
            //     number++;
            // }
            return count; 
        }
    }
}

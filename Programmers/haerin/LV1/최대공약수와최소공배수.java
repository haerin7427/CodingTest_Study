// https://school.programmers.co.kr/learn/courses/30/lessons/12940
// title : 최대공약수와 최소공배수
// time : 7m
// type : 숫자
// Created by haerin on 2023/01/18
public class 최대공약수와최소공배수 {
    class Solution {
        public int[] solution(int n, int m) {
            int min = n < m ? n : m;
            int max = n < m ? m : n;
            
            int[] answer = new int[2];
            
            for(int i=min; i>0; i--) {
                if(max%i==0 && min%i==0) {
                    answer[0] = i;
                    break;
                }
            }
            for(int i=max; i <= min*max; i++) {
                if(i%max==0 && i%min==0) {
                    answer[1] = i;
                    break;
                }
            }
            return answer;
        }
    }
}

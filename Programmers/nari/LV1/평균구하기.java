// https://school.programmers.co.kr/learn/courses/30/lessons/12944
// title : 평균구하기

public class 평균구하기 {
    class Solution {
        public double solution(int[] arr) {
            double sum = 0;
            
            for(int i: arr) {
                sum += i;
            }
            
            double answer = sum/arr.length;
            
            return answer;
        }
    }
}
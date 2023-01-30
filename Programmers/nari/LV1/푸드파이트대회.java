// https://school.programmers.co.kr/learn/courses/30/lessons/134240
// title : 푸드 파이트 대회

public class 푸드파이트대회 {
    class Solution {
        public String solution(int[] food) {
            StringBuilder sb = new StringBuilder();
            
            for(int i=1;i<food.length;i++) {
                if(food[i] == 1) continue;
                
                for(int j=0;j<food[i]/2;j++) {
                    sb.append(i);
                }
            }
            
            return sb.toString() + "0" + sb.reverse().toString();
        }
    }
}
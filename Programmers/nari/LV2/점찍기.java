// https://school.programmers.co.kr/learn/courses/30/lessons/140107
// title : 점 찍기

public class 점찍기 {
    class Solution {
        public long solution(int k, int d) {
            long answer = 0;
            
            // 문제 : 원점과 찍은 점의 거리가 d이하인 양의 정수인 점의 개수를 구하는 것
            // '양의 정수'라는 제한 조건을 버려두고, 위의 조건을 만족하는 무수히 많은 실수 좌표의 점들을 찍어보면 해당 점들은 "원의 방정식"을 만족
            // 원의 방정식 : x^2 + y^2 <= d^2 (x >= 0, y >= 0)
            
            for(long i=0;i<=d/k;i++) {
                long x = i * k;
                long y = (long) Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(x, 2));
            
                // 0도 포함해야하기 때문에 +1
                answer += y / k + 1; 
            }
            
            return answer;
        }
    }
}
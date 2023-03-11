// https://school.programmers.co.kr/learn/courses/30/lessons/12938
// title : 최고의 집합

public class 최고의집합 {
    class Solution {
        public int[] solution(int n, int s) {
            // 1가지 경우의 수도 나오지 않는 경우
            if(s/n == 0) return new int[]{-1};
            
            int[] answer = new int[n];
            int idx = 0;
            
            // ex1)
            // n = 2, answer[0] = 9/2 = 4, s = 9-4 = 5
            // n = 1, answer[1] = 5/1 = 5, s = 5-5 = 0
            
            // ex2)
            // n = 2, answer[0] = 8/2 = 4, s = 8-4 = 4
            // n = 1, answer[1] = 4/1 = 4, s = 4-4 = 0
            
            while(n > 0) {
                answer[idx++] = s/n;
                s -= s/n;
                n--;
            }
            
            return answer;
        }
    }
}
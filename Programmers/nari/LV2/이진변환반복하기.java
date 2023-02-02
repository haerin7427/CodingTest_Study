// https://school.programmers.co.kr/learn/courses/30/lessons/70129
// title : 이진 변환 반복하기

public class 이진변환반복하기 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];
            int cnt = 0;
            
            while(s.length() != 1) {
                int zeroCnt = 0, length = s.length();
                
                for(int i=0;i<s.length();i++) {
                    if(s.charAt(i) == '0') zeroCnt++;
                }
                
                s = Integer.toBinaryString(length-zeroCnt);
                cnt++;
                answer[1] += zeroCnt;
            }
            
            answer[0] = cnt;
            
            return answer;
        }
    }
}
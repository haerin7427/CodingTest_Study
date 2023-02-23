// https://school.programmers.co.kr/learn/courses/30/lessons/17687
// title : [3차] n진수 게임

public class n진수게임 {
    class Solution {
        public String solution(int n, int t, int m, int p) {
            StringBuilder sb = new StringBuilder();
            StringBuilder answer = new StringBuilder();
            int num = 0;
            
            // m 명이 t 갯수만큼 말할 때까지 반복
            while(sb.length() < t*m) {
                // 10~15는 각각 a~f로 변환해줌 -> 대문자 변환 필요
                sb.append(Integer.toString(num++, n));
            }
            
            // p는 순서 -> index로 변환하기 위해 -1
            // 튜브가 말하는 것만 알면 되니까 인원수 m만큼씩 증가
            // i의 범위는 sb.length()가 t*m보다 클 수도 있어서 t*m이 맞다.
            for(int i=p-1;i<t*m;i+=m) {
                answer.append(sb.charAt(i));
            }
            
            return answer.toString().toUpperCase();
        }
    }
}
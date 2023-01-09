// https://school.programmers.co.kr/learn/courses/30/lessons/12932
// title : 자연수 뒤집어 배열로 만들기

public class 자연수뒤집어배열로만들기 {
    class Solution {
        public int[] solution(long n) {
            // long을 string으로 변환
            String num = Long.toString(n);
            int[] answer = new int[num.length()];
            int cnt = num.length()-1;
            
            // 문자열 사이즈만큼 반복문
            for(int i=0;i<num.length();i++) {
                // 문자 int로 변환 후, 배열에 넣기
                answer[i] = Character.getNumericValue(num.charAt(cnt));
                cnt--;
            }
            
            return answer;
        }
    }
}
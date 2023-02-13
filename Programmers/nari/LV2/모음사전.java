// https://school.programmers.co.kr/learn/courses/30/lessons/84512
// title : 모음 사전

public class 모음사전 {
    class Solution {
        public int solution(String word) {
            // 1: A
            // 2: AA
            // 3: AAA
            // 4: AAAA
            // 5: AAAAA
            // 6: AAAAE
            // 7: AAAAU
            // ...
            // 10: AAAE
            // 11: AAAEA
            // ...
            // 16: AAAI
            // ...
            // 22: AAAO
            // ...
            // 28: AAAU
            // ...
            // 34: AAE
            // ...
            // 5번째 자리 문자가 바뀔 때는 1씩 증가
            // 4번째 자리 문자는 6씩 증가
            // 3번째 자리인 경우는 31씩 증가
            
            // 규칙
            // x 가 0이 아닐 때 : f(x) = f(x - 1) + 5^x
            // f(0) = 1
            // f(1) = 1 + 5^1 = 6
            // f(2) = 6 + 5^2 = 31
            // f(3) = 31 + 5^3 = 156
            // f(4) = 156 + 5^4 = 781
            
            int answer = word.length();
            String str = "AEIOU";
            int[] rate = {781, 156, 31, 6, 1};

            // 각 자릿수에 대한 증가율과 대치된 문자의 값 곱하기
            for(int i=0;i<word.length();i++){
                answer += rate[i] * str.indexOf(word.charAt(i));
            }
            
            return answer;
        }
    }
}
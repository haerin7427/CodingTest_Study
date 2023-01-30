// https://school.programmers.co.kr/learn/courses/30/lessons/140108
// title : 문자열 나누기
// time : 20m
// type : 
// Created by haerin on 2023-01-30
public class 문자열나누기 {
    class Solution {
        public int solution(String s) {
            boolean isFirst = false;
            char temp=s.charAt(0);
            int cntSame = 1;
            int cntDiff = 0;
            int answer = 0;
            
            for(int i=1; i<s.length(); i++) {
                if(isFirst) {
                    temp = s.charAt(i);
                    cntSame=1;
                    cntDiff=0;
                    isFirst = false;
                }else {
                    if(temp == s.charAt(i)) {
                        cntSame += 1;
                    }else {
                        cntDiff += 1;
                    }
                }
                
                if(cntSame == cntDiff || i == s.length()-1) {
                    answer += 1;
                    isFirst = true;
                }
            }
            if(s.length() == 1) {
                answer += 1;
            }
            return answer;
        }
    }
    // 문자열 카운트를 문자열 생성 때 하면 코드가 더 간단해짐
    class Solution2 {
        public int solution(String s) {
            char prev = '1';
            int same = 0, different = 0, answer = 0;
            for (char c : s.toCharArray()) {
                if (prev == '1') {
                    prev = c;
                    same++;
                    answer++;
                } else if (prev == c) {
                    same++;
                } else {
                    different++;
                }
    
                if (same == different) {
                    prev = '1';
                    same = 0; different = 0;
                }
            }
            return answer;
        }
    }
}

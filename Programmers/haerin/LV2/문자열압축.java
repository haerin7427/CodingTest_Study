package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/60057
// title : 문자열 압축
// type : 문자열
// time : 34m
// Created by haerin on 2023-02-27
public class 문자열압축 {
    class Solution {
        public int solution(String s) {
            int min = s.length();
            // i는 문자열 단위 길이, i가 s.length()/2를 초과하면 반복이 압축이 불가능하므로 제한 
            for(int i=1; i<=s.length()/2; i++){
                String key = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                int idx=i;
                int cnt = 1;
                while(idx+i <= s.length()){
                    if(key.equals(s.substring(idx, idx+i))){
                        cnt += 1;
                    }else{
                        if(cnt > 1){
                            sb.append(cnt);
                        }
                        sb.append(key);
                        
                        key = s.substring(idx, idx+i);
                        cnt = 1;
                    }
                    
                    // 1. 문자열(abc/abc/abc)를 3개 단위로 잘라서 압축할 경우
                    // 2. 문자열(abc/adc/ab)의 마지막 3개 단위 문자열(adc)가 추가되지 않은 채로 반복문이 종료될 경우
                    if(idx+i == s.length() || idx+i+i > s.length()){ 
                        if(cnt > 1){
                            sb.append(cnt);
                        }
                        sb.append(key);
                    }
                    idx += i;
                } 
                // 마지막 남은 문자열
                sb.append(s.substring(idx));
                if(min > sb.length()) {
                    min = sb.length();
                }
            }
            return min;
        }
    }
}

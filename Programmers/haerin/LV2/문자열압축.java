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
                    
                    if(idx+i == s.length() || idx+i+i > s.length()){
                        if(cnt > 1){
                            sb.append(cnt);
                        }
                        sb.append(key);
                    }
                    idx += i;
                }
                            
                
                if(sb.length() == 0) continue;
                
                sb.append(s.substring(idx));
                if(min > sb.length()){
                    min = sb.length();
                }
    
            }
            return min;
        }
    }
}

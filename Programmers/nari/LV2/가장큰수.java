// https://school.programmers.co.kr/learn/courses/30/lessons/42746
// title : 가장 큰 수

import java.util.*;

public class 가장큰수 {
    class Solution {
        public String solution(int[] numbers) {
            StringBuilder sb = new StringBuilder();
            
            // 자리수 하나하나 비교? -> 시간 오래 걸림
            
            // string 배열로 변환
            String[] str = new String[numbers.length];
            for(int i=0;i<numbers.length;i++) {
                str[i] = String.valueOf(numbers[i]);
            }
            
            // 사전순으로 비교
            // [3, 30] -> 330 > 303
            Arrays.sort(str, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    return (b+a).compareTo(a+b);
                }
            });
            
            // 예외처리 -> [0, 0, 0]이 존재할 때, 0만 반환
            if(str[0].equals("0")) return "0";
            else {
                for(String s: str) sb.append(s);
                
                return sb.toString();
            }
        }
    }
}
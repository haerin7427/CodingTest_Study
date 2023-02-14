// https://school.programmers.co.kr/learn/courses/30/lessons/17677
// title : [1차] 뉴스 클러스터링

import java.util.*;

public class 뉴스클러스터링 {
    class Solution {
        public int solution(String str1, String str2) {
            ArrayList<String> list1 = new ArrayList<>();
            ArrayList<String> list2 = new ArrayList<>();
            ArrayList<String> union = new ArrayList<>();
            ArrayList<String> intersection = new ArrayList<>();
            
            str1 = str1.toLowerCase();
            str2 = str2.toLowerCase();
            
            // str1 다중집합
            for(int i=0;i<str1.length()-1;i++) {
                char a = str1.charAt(i);
                char b = str1.charAt(i+1);

                // 기타 공백이나 숫자, 특수 문자인 경우 제외
                if(Character.isLetter(a) && Character.isLetter(b))
                    list1.add(Character.toString(a) + Character.toString(b));
            }
            
            // str2 다중집합
            for(int i=0;i<str2.length()-1;i++) {
                char a = str2.charAt(i);
                char b = str2.charAt(i+1);

                // 기타 공백이나 숫자, 특수 문자인 경우 제외
                if(Character.isLetter(a) && Character.isLetter(b))
                    list2.add(Character.toString(a) + Character.toString(b));
            }
            
            // 합집합, list2에도 포함된 문자열이면 교집합 추가 + list2에서 삭제
            for(String s : list1) {
                if(list2.contains(s)) {
                    list2.remove(s);
                    intersection.add(s);
                }
                
                union.add(s);
            }
            
            // 합집합
            for(String s : list2) {
                union.add(s);
            }
            
            // 공집합일 경우, 1로 판정
            if(union.size() == 0) return 65536;
            else {
                double d = (double) intersection.size() / (double) union.size();
                
                return (int) (d * 65536);
            }
        }
    }
}
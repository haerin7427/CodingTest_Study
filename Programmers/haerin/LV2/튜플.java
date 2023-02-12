package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/64065
// title : 튜플
// type : ...
// time : 23m, 16m
// Created by haerin on 2023-02-10, 2023-02-12
import java.util.*;
public class 튜플 {
    class Solution {
        public int[] solution(String s) {
            // s = "{{2},{2, 1},{2, 1, 3},{2, 1, 3, 4}}" 문자열 파싱 -> {"2","2,1","2,1,3","2,1,3,4"}
            String[] temp = s.split("\\},\\{");
            temp[0] = temp[0].replaceAll("[{}]","");
            temp[temp.length-1] = temp[temp.length-1].replaceAll("[{}]","");
            
            // temp[i]의 길이 순으로 정렬
            String[][] sortedStr = new String [temp.length][];
            for(int i=0; i<temp.length; i++){
                String[] ss = temp[i].split(",");
                sortedStr[ss.length-1] = ss;
            }
            
            Set<String> set = new HashSet<>();
            int[] answer = new int[sortedStr.length];
            for(int i=0; i<answer.length; i++) {
                for(int j=0; j<sortedStr[i].length; j++){
                    if(!set.contains(sortedStr[i][j])){
                        set.add(sortedStr[i][j]);
                        answer[i] = Integer.valueOf(sortedStr[i][j]);
                        break;
                    }
                }
            }
            return answer;
        }
    }
    class Solution2 {
        public int[] solution(String s) {
            String[] str = s.replaceAll("[}{]", " ").trim().split(" , ");
            Arrays.sort(str, (o1, o2)->{return o1.length() - o2.length();});
            
            Set<String> set = new HashSet<>();
            int[] answer = new int[str.length];
            int idx = 0;
            for(String tuple : str) {
                for(String num : tuple.split(",")){
                    if(set.add(num)){
                        answer[idx++] = Integer.parseInt(num);
                    }
                }
            }
            return answer;
        }
    }
}

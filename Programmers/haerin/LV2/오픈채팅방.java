package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42888
// title : 오픈채팅방
// type : 문자열
// time : 23m
// Created by haerin on 2023-02-21
import java.util.*;
public class 오픈채팅방 {
    class Solution {
        public String[] solution(String[] record) {
            HashMap<String, String> nameMap = new HashMap<>();
            for(String r : record) {
                String[] code = r.split(" ");
                if(code[0].equals("Enter") || code[0].equals("Change")){
                    nameMap.put(code[1], code[2]);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(String r : record) {
                String[] code = r.split(" ");
                
                if(code[0].equals("Enter")){
                    sb.append(nameMap.get(code[1]) + "님이 들어왔습니다.,");
                }else if(code[0].equals("Leave")){
                    sb.append(nameMap.get(code[1]) + "님이 나갔습니다.,");
                }
            }
            
            sb.deleteCharAt(sb.length()-1);        
            String[] answer = sb.toString().split(",");
            return answer;
        }
    }
}

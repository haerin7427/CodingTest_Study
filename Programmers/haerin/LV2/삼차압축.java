package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/17684
// title : [3차] 압축
// type : 문자열
// time : 42m
// Created by haerin on 2023-02-21
import java.util.*;
public class 삼차압축 {
    class Solution {
        public int[] solution(String msg) {
            Map<String, Integer> dictionary = new HashMap<>();
            for(int i=65; i<91; i++){
                char word = (char) i;
                dictionary.put(String.valueOf(word), i-64);
            }
            List<Integer> list = new ArrayList<>();
    
            for(int i=0; i<msg.length(); i++){
                if(i == msg.length()-1){
                    list.add(dictionary.get(msg.substring(i)));
                }else{
                    StringBuilder sb = new StringBuilder();
                    sb.append(msg.substring(i, i+2));
                    int idx = i+1;
                    while(dictionary.get(sb.toString()) != null){
                        if(idx < msg.length()-1){
                            idx += 1;
                            sb.append(msg.charAt(idx));
                        }else{
                            list.add(dictionary.get(sb.toString()));
                            i = msg.length()-1;
                            break;
                        }
                    }
                    
                    if(dictionary.get(sb.toString()) == null){
                        int no = dictionary.size()+1;
                        dictionary.put(sb.toString(), no);
                        list.add(dictionary.get(msg.substring(i, idx)));
                        i = idx - 1;
                    }
                }   
            }
            int[] answer = new int[list.size()];
            int idx=0;
            for(int num : list){
                answer[idx++] = num;
            }
            return answer;
        }
    }
}

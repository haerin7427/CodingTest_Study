// https://school.programmers.co.kr/learn/courses/30/lessons/17684
// title : [3차] 압축

import java.util.*;

public class 압축 {
    class Solution {
        public int[] solution(String msg) {
            // 단어 사전 map
            HashMap<String, Integer> wordMap = new HashMap<>();
            // 색인 번호
            int wordIdx = 1;
            
            // 아스키코드: 'A'=65, 'Z'=90
            // 길이가 1인 모든 단어로 사전 초기화
            for(int i=65;i<=90;i++) {
                wordMap.put(String.valueOf((char)i), wordIdx++) ;
            }
            
            // 압축 list
            ArrayList<Integer> list = new ArrayList<>();
            int msgIdx = 0;
            while(msgIdx < msg.length()) {
                StringBuilder w = new StringBuilder();
                
                while(msgIdx < msg.length()) {
                    // 단어 사전에 없는 경우
                    if(!wordMap.containsKey(w.toString() + msg.charAt(msgIdx))) 
                        break;
                    else w.append(msg.charAt(msgIdx++));
                }
                
                list.add(wordMap.get(w.toString()));
                
                // msgIdx가 msg.length보다 작은 경우 = 단어 사전에 없어서 break된 경우
                // 단어 사전에 추가
                if(msgIdx < msg.length()) {
                    w.append(msg.charAt(msgIdx));
                    wordMap.put(w.toString(), wordIdx++);
                }
            }
            
            int[] answer = new int[list.size()];
            
            for(int i=0;i<list.size();i++){
                answer[i] = list.get(i);
            }
            
            return answer;
        }
    }
}
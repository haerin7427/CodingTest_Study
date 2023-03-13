// https://school.programmers.co.kr/learn/courses/30/lessons/160586
// title : 대충 만든 자판

import java.util.*;

public class 대충만든자판 {
    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];
            
            for(int i=0;i<targets.length;i++) {
                // 자판 누르는 횟수
                int sum = 0;
                
                for(int j=0;j<targets[i].length();j++) {
                    PriorityQueue<Integer> queue = new PriorityQueue<>();
                    
                    for(int a=0;a<keymap.length;a++) {
                        String str = Character.toString(targets[i].charAt(j));
                        
                        // keymap에 해당 문자가 존재한 경우, index 저장
                        if(keymap[a].contains(str)) queue.add(keymap[a].indexOf(str));
                        // 100이 최대길이
                        else queue.add(101);
                    }
                    
                    // 최소 값이 최대길이인 경우, 목표 문자열을 작성할 수 없을 때라고 판단
                    if(queue.peek() == 101) {
                        sum = -1;
                        break;
                    }
                    else sum += queue.poll()+1;
                }
                
                answer[i] = sum;
            }
            
            return answer;
        }
    }
}
package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42587
// title : 프린터
// type : Queue
// time : 15m
// Created by haerin on 2023-02-15
import java.util.*;
public class 프린터 {
    class Solution {
        class Document{
            int priority;
            int index;
            Document(int p, int i){
                this.priority = p;
                this.index = i;
            }
        }
        public int solution(int[] priorities, int location) {
            Queue<Document> queue = new LinkedList<>();
            int idx = 0;
            for(int priority : priorities){
                queue.add(new Document(priority, idx++));
            }
            
            Arrays.sort(priorities);
            int answer = 0;
            int cnt = 0;
            for(int i=priorities.length-1; i>=0; i--){
                Document d = queue.remove();
                while(d.priority != priorities[i]){
                    queue.add(d);
                    d = queue.remove();
                }
                cnt += 1;
                if(d.index == location){
                    answer = cnt;
                    break;
                }
            }
            return answer;
        }
    }
}

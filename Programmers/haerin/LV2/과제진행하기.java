package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/176962
// title : 과제 진행하기
// type : 구현
// time : 30m
// Created by haerin on 2023-04-06
import java.util.*;
public class 과제진행하기 {
    class Solution {
        class Subject {
            String name;
            int startTime;
            int time;
            
            Subject () {}
            
            Subject (String name, String startTime, String time) {
                String[] tmp = startTime.split(":");
                this.name = name;
                this.startTime = Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
                this.time = Integer.parseInt(time);
            }
        }
        
        public String[] solution(String[][] plans) {
            List<Subject> list = new ArrayList<>();
            for(String[] plan : plans){
                list.add(new Subject(plan[0], plan[1], plan[2]));
            }
            Collections.sort(list, (o1, o2) -> o1.startTime - o2.startTime);
            
            String[] answer = new String[plans.length];
            Stack<Subject> waitingStack = new Stack<>();
            Subject curSub = new Subject();
            int current = 0;
            int dur = -1;
            int idx = 0;
            for(int i = 0; i<list.size(); i++){
                
                if(current+dur > list.get(i).startTime){
                    // 앞의 과제를 중단하고 새 과제 시작
                    curSub.time -= (list.get(i).startTime - curSub.startTime);
                    waitingStack.push(curSub);
                }else if(!waitingStack.isEmpty()){
                    // 앞의 과제가 새 과제 전에 끝났고 잠시 멈춘 과제가 있는 경우
                    answer[idx++] = list.get(i-1).name;
                    current += dur;
                    while(!waitingStack.isEmpty() && current < list.get(i).startTime){
                        Subject tmp = waitingStack.pop();
                        if(current + tmp.time <= list.get(i).startTime){
                            current += tmp.time;
                            answer[idx++] = tmp.name;
                        }else{
                            tmp.time -= (list.get(i).startTime - current);
                            waitingStack.push(tmp);
                            current = list.get(i).startTime;
                        }
                        
                    }
                }else if(i>0){
                    // 앞의 과제가 새 과제 전에 끝났고 멈춘 과제가 없는 경우
                    answer[idx++] = list.get(i-1).name;
                }
                
                // 새 과제 시작
                curSub = list.get(i);
                current = list.get(i).startTime;
                dur = list.get(i).time;
                if(i == list.size()-1){
                    answer[idx++] = list.get(i).name;
                }
            }
            
            while(!waitingStack.isEmpty()){
                answer[idx++] = waitingStack.pop().name;
            }
            return answer;
        }
    }
}

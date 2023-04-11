// https://school.programmers.co.kr/learn/courses/30/lessons/176962
// title : 과제 진행하기

import java.util.*;

public class 과제진행하기 {
    class Solution {
        public String[] solution(String[][] plans) {
            String[] answer = new String[plans.length];
            int idx = 0;
            Stack<String> name = new Stack<>();
            HashMap<String, Integer> start = new HashMap<>();
            HashMap<String, Integer> playtime = new HashMap<>();
            
            for(String[] plan : plans) {
                String n = plan[0];
                String[] startSplit = plan[1].split(":");
                int s = Integer.parseInt(startSplit[0])*60 + Integer.parseInt(startSplit[1]);
                int play = Integer.parseInt(plan[2]);
                
                start.put(n, s);
                playtime.put(n, play);
            }
            
            // 시작시간을 기준으로 정렬
            ArrayList<String> keySetList = new ArrayList<>(start.keySet());
            Collections.sort(keySetList, (o1, o2) -> (start.get(o1).compareTo(start.get(o2))));
            
            for(int i=0;i<keySetList.size();i++) {
                if(i == keySetList.size()-1) {
                    answer[idx++] = keySetList.get(i);
                    break;
                }
                
                String curKey = keySetList.get(i);
                String nextKey = keySetList.get(i+1);
                
                int cur = start.get(curKey);
                int next = start.get(nextKey);
                
                // 다음 과제의 시작 시간 - 현재 과제의 시작 시간 -> 두 과제 사이의 시간 구하기
                int minus = next - cur;
                // 진행중인 과제를 마치는데 걸리는 시간
                int play = playtime.get(curKey);
                
                // 두 과제 사이의 시간이 진행중인 과제의 걸리는 시간보다 빠른 경우
                if(minus < play) {
                    // 진행중인 과제 걸리는 시간 - 두 과제 사이 시간 -> 남은 시간
                    playtime.replace(curKey, play - minus);
                    // stack에 저장
                    name.push(curKey);
                }
                // 두 과제 사이의 시간이 진행중인 과제의 걸리는 시간하고도 남는 경우
                else if(minus > play) {
                    answer[idx++] = curKey;
                    
                    int remaining = minus - play;
                    
                    while(!name.isEmpty() && remaining > 0) {
                        String str = name.pop();
                        int remainingPlay = playtime.get(str);
                        
                        // 다음 과제하러
                        if(remaining-remainingPlay < 0) {
                            playtime.replace(str, remainingPlay - remaining);
                            name.push(str);
                            remaining = 0;
                        }
                        else {
                            answer[idx++] = str;
                            remaining -= remainingPlay;
                        }
                    }
                }
                // 두 과제 사이의 시간이 진행중인 과제의 걸리는 시간과 같을 경우는 continue
                else answer[idx++] = curKey;
            }
            
            while(!name.isEmpty()) {
                answer[idx++] = name.pop();
            }
            
            return answer;
        }
    }
}
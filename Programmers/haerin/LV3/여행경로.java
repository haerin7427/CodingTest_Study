package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/43164
// title : 여행경로
// type : dfs
// time : 35m, 31m
// Created by haerin on 2023-03-14, 2023-05-02
import java.util.*;
public class 여행경로 {
    // 런타임 에러
    class Solution {
        public String[] solution(String[][] tickets) {
            String[] answer = new String[tickets.length+1];
            answer[0] = "ICN";
            for(int i=1; i<answer.length; i++){
                int idx = -1;
                for(int t=0; t<tickets.length; t++){
                    if(answer[i-1].equals(tickets[t][0])){
                        if(idx == -1 || tickets[idx][1].compareTo(tickets[t][1]) > 0){
                            idx = t;
                        }
                    }
                }
                answer[i] = tickets[idx][1];
                tickets[idx][1] = "ZZZ";
            }
            return answer;
        }
    }
    // 런타임 에러
    class Solution2 {
        public String[] solution(String[][] tickets) {
            String[] answer = new String[tickets.length+1];
            boolean[] isVisted = new boolean[tickets.length+1];
            
            answer[0] = "ICN";
            dfs(tickets, isVisted, answer, "ICN", 1);
            return answer;
        }
        
        public void dfs(String[][] tickets, boolean[] isVisted, String[] answer, String departures, int idx){
            if(idx > tickets.length){
                return;
            }
            
            int index = -1;
            for(int t=0; t<tickets.length; t++){
                if(departures.equals(tickets[t][0]) && !isVisted[t]){
                    if(index == -1 || tickets[index][1].compareTo(tickets[t][1]) > 0){
                        index = t;
                    }
                }
            }
    
            answer[idx] = tickets[index][1];
            isVisted[index] = true;
            dfs(tickets, isVisted, answer, answer[idx], idx+1);
        }
    }
    // 통과
    class Solution3 {
        ArrayList<String> list = new ArrayList<>();
        boolean[] isVisted;
        public String[] solution(String[][] tickets) {
            isVisted = new boolean[tickets.length];
            dfs(0, "ICN", "ICN", tickets);
            
            Collections.sort(list);
            return list.get(0).split(" ");
        }
        
        public void dfs (int depth, String now, String path, String[][] tickets){
            if (depth == tickets.length) {
                list.add(path);
                return;
            }
    
            for (int i = 0; i < isVisted.length; i++) {
                if (!isVisted[i] && now.equals(tickets[i][0])) {
                    isVisted[i] = true;
                    dfs(depth+1, tickets[i][1], path + " " +tickets[i][1], tickets);
                    isVisted[i] = false;
                }
            }
        }
    }
    // 05.02 2차시도 성공
    class Solution4 {
        private int N;
        private List<String[]> answerList = new ArrayList<>();
        private boolean[] isUsed;
        public String[] solution(String[][] tickets) {
            N = tickets.length + 1;
            isUsed = new boolean[N-1];
            String[] tmp = new String[N];
            tmp[0] = "ICN";
            dfs(1, tmp, "ICN", tickets);
    
            Collections.sort(answerList, new Comparator<String[]>(){
                @Override
                public int compare(String[] o1, String[] o2){
                    StringBuilder sb1 = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    for(int i=0; i<o1.length; i++){
                        sb1.append(o1[i]);
                        sb2.append(o2[i]);
                    }
                    return sb1.toString().compareTo(sb2.toString());
                }
            });
            
            return answerList.get(0);
        }
        private void dfs(int idx, String[] tmp, String departure, String[][] tickets){
            if(idx == N){
                answerList.add(tmp.clone());
            }
            
            for(int i=0; i<tickets.length; i++){
                if(tickets[i][0].equals(departure) && !isUsed[i]){
                    isUsed[i] = true;
                    tmp[idx] = tickets[i][1];
                    dfs(idx+1, tmp, tickets[i][1], tickets);
                    isUsed[i] = false;
                }
            }
        }
    }
}

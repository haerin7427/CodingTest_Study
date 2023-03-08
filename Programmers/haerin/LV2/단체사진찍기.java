package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/1835
// title : 단체사진 찍기
// type : dfs
// time : 16m
// Created by haerin on 2023-03-08
public class 단체사진찍기 {
    class Solution {
        private String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
        
        public int solution(int n, String[] data) {
            boolean[] isVisted = new boolean[8];
            int answer = dfs("", isVisted, data);
            return answer;
        }
        
        public int dfs(String names, boolean[] isVisited, String[] datas){
            int cnt = 0;
            if(names.length() == 8){
                if(isCorrect(names, datas)){
                    cnt += 1;
                }
            }else{
                for(int i=0; i<8; i++){
                    if(!isVisited[i]){
                        isVisited[i] = true;
                        cnt += dfs(names+friends[i], isVisited, datas);
                        isVisited[i] = false;
                    }
                }
            }
            return cnt;
        }
        
        public boolean isCorrect(String names, String[] datas){
            for (String d : datas) {
                int position1 = names.indexOf(d.charAt(0)); 
                int position2 = names.indexOf(d.charAt(2)); 
                char op = d.charAt(3); 
                int distance = (d.charAt(4) -'0')+1; 
                if (op == '=') {
                    if (!(Math.abs(position1 - position2) == distance)) return false; 
                } else if (op == '>') {
                    if (!(Math.abs(position1 - position2) > distance)) return false;
                } else if (op == '<') {
                    if (!(Math.abs(position1 - position2) < distance)) return false;
                }
            }
            return true;
        }
    }
}

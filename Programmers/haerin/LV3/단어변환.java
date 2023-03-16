package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/43163
// title : 단어 변환
// type : dfs
// time : 17m
// Created by haerin on 2023-03-16
public class 단어변환 {
    class Solution {
        public int answer = Integer.MAX_VALUE;
        public int solution(String begin, String target, String[] words) {
            boolean[] isVisited = new boolean[words.length];
            dfs(words, isVisited, target, begin, 0);
            return answer == Integer.MAX_VALUE ? 0 : answer;
        }
        
        public void dfs(String[] words, boolean[] isVisited, String target, String now, int cnt){
            if(target.equals(now)){
                answer = Math.min(answer, cnt);
            }
            
            for(int i=0; i<words.length; i++){
                if(!isVisited[i] && isPossible(now, words[i])){
                    isVisited[i] = true;
                    dfs(words, isVisited, target, words[i], cnt+1);
                    isVisited[i] = false;
                }
            }
        }
        
        public boolean isPossible(String s, String t){
            int cnt = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) != t.charAt(i)){
                    cnt += 1;
                }
            }
            return cnt == 1 ? true : false;
        }
    }
}

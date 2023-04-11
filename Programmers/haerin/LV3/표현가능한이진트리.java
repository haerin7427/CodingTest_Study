package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/150367
// title : 표현 가능한 이진트리
// type : DFS
// time : 1h
// Created by haerin on 2023-04-10
public class 표현가능한이진트리 {
    class Solution {
        public int[] solution(long[] numbers) {
            int[] answer = new int[numbers.length];
            for(int i=0; i<numbers.length; i++){
                String s = Long.toBinaryString(numbers[i]);
                
                int level = 0;
                while(Math.pow(2, level+1)-1 < s.length()){
                    level += 1;
                }
                
                int numDummy = (int)Math.pow(2, level+1)-1 - s.length();
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<numDummy; j++){
                    sb.append("0");
                }
                sb.append(s);
                if(dfs(sb.toString(), sb.toString().length()/2, level-1, '1')){
                    answer[i] = 1;
                }
            }
            return answer;
        }
        
        public boolean dfs(String s, int idx, int p, char root){
            if(root == '0' && s.charAt(idx) =='1'){
                return false;
            }
            
            if(p > -1){
                int i1 = idx - (int)Math.pow(2, p);
                int i2 = idx + (int)Math.pow(2, p);
                if(!dfs(s,i1, p-1, s.charAt(idx)) || !dfs(s,i2,p-1,s.charAt(idx))){
                    return false;
                }
            }
            return true;
        }
    }
}

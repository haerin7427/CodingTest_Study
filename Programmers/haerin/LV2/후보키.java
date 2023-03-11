package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42890
// title : 후보키
// type : 구현(백트랙킹)
// time : 1h 10m
// Created by haerin on 2023-03-11
import java.util.*;;
public class 후보키 {
    class Solution {
        public List<String> relationCombination = new ArrayList<>();
        public int solution(String[][] relation) {
            // 1. 속성 조합 모두 찾기
            int n = relation[0].length;
            int[] arr = new int[n];
            boolean[] isVisited = new boolean[n];
            for(int i=1; i<n; i++){
                arr[i] = i;
            }
            for(int r=1; r<=n; r++){
                combination(arr, isVisited, 0, n, r);
            }        
            
            // 2. 유일성과 최소성 가지는 조합인지 확인
            List<String> ansCombination = new ArrayList<>();
            for(String s : relationCombination){
                if(isUnique(s, relation) && isMinimized(ansCombination, s)){
                    ansCombination.add(s);
                }
            }
            
            int answer = ansCombination.size();
            return answer;
        }
        
        public boolean isMinimized(List<String> ansCombination, String combination){
            for(String unc : ansCombination){
                // 새로운 속성 조합인 combination에 기존 속성 조합이 속해있는지 확인
                boolean flag = true;
                for(String attribute : unc.split(",")){
                    if(!combination.contains(attribute)){
                        flag = false;
                        break;
                    }
                }
                
                // 속해있다면, 최소성을 위배하므로 false 리턴
                if(flag){
                    return false;
                }
            }
            return true;
        }
        
        public boolean isUnique(String combination, String[][] relation){
            String[] attribute = combination.split(",");
            Set<String> set = new HashSet<>();
            for(String[] tuple : relation){
                StringBuilder sb = new StringBuilder();
                for(String a : attribute){
                    sb.append(tuple[Integer.parseInt(a)]+",");
                }
                set.add(sb.toString());
            }
            return set.size() == relation.length ? true : false;
        }
        
        public void makeCombinationString(boolean[] isVisited){
            List<String> temp = new ArrayList<>();
            for(int i=0; i<isVisited.length; i++){
                if(isVisited[i]){
                    temp.add(Integer.toString(i));
                }
            }
            String s = String.join(",", temp);
            relationCombination.add(s);
        }
        
        public void combination(int[] arr, boolean[] isVisited, int startIdx, int n, int r){
            if(r == 0){
                makeCombinationString(isVisited);
                return;
            }
            for(int i=startIdx; i<n; i++){
                isVisited[i] = true;
                combination(arr, isVisited, i+1, n, r-1);
                isVisited[i] = false;
            }
        }
    }
}

package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/172927
// title : 광물 캐기
// type : Greedy
// time : 30m
// Created by haerin on 2023-03-30
import java.util.*;
public class 광물캐기 {
    class Solution {
        public int solution(int[] picks, String[] minerals) {
            int N = 0; // 곡갱이 총 개수
            for(int p : picks){
                N += p;
            }
            int M = minerals.length / 5; // 광물을 5개씩 묶은 그룹의 개수
            if(minerals.length % 5 != 0){
                M +=1;
            }
            int limit = Math.min(N, M); // 광물 또는 곡갱이가 없을 때 까지 깰 수 있는 그룹의 개수
            int[][] group = new int[limit][3];
            int cnt=0, idx=0;
            for(String m : minerals){ // 그룹별 광물별 개수를 구하기
                if(cnt == 5){
                    idx += 1;
                    cnt = 0;
                }
                if(idx == limit) break;
                if(m.equals("diamond")){
                    group[idx][0] += 1;
                }else if(m.equals("iron")){
                    group[idx][1] += 1;
                }else{
                    group[idx][2] += 1;
                }
                cnt += 1;
            }
            
            Arrays.sort(group, new Comparator<int[]>(){ // 다이아몬드, 철, 돌 의 개수 기준으로 내림차순 정렬
                @Override
                public int compare(int[] o1, int[] o2){
                    if(o1[0] != o2[0]){
                        return o2[0] - o1[0];
                    }else if(o1[1] != o2[1]){
                        return o2[1] - o1[1];
                    }else{
                        return o2[2] - o1[2];
                    }
                }
            });
            
            int answer = 0;
            idx = 0;
            for(int[] g : group){ // 피로도가 낮은 곡괭이부터 소진하여 그룹에 배정하기
                while(idx < picks.length && picks[idx] == 0){
                    idx += 1;
                }
                if(idx >= picks.length){
                    break;
                }
                
                if(idx > 0){
                    g[1] *= Math.pow(5, idx-1);
                }
                answer += (g[0]*Math.pow(5, idx) + g[1] + g[2]);
                
                picks[idx] -= 1;
            }
            return answer;
        }
    }
}

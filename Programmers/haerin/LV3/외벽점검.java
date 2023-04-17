package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/60062#
// title : 외벽 점검
// type : 완전탐색 & 순열
// time : ...
// Created by haerin on 2023-04-14
import java.util.*;
public class 외벽점검 {
    class Solution {
        List<int[]> weakCaseList;
        boolean[] isVisted;
        private int min = Integer.MAX_VALUE;
        public int solution(int n, int[] weak, int[] dist) {
            // 취약점 삭제 순서 케이스 모든 만들기
            makeWeakCase(n, weak);
            // 친구들 점검 순서 모든 케이스에서 외벽 점검 하는 데 몇명이 필요한 지 확인하기
            isVisted = new boolean[dist.length];
            makeDistCases(0, new int[dist.length], dist);
            // 취약점을 전부 처리하지 못하는 경우 처리
            return min == Integer.MAX_VALUE ? -1 : min;
        }
        
        private void makeWeakCase(int n, int[] weak) {
            weakCaseList = new ArrayList<>();
            weakCaseList.add(weak);
            for(int i=0; i<weak.length-1; i++){
                weak[0] += n;
                // 오름차순 정렬
                Arrays.sort(weak);
                weakCaseList.add(weak.clone());
            }
        }
        
        private void makeDistCases(int dept, int[] distCase, int[] dist){
            if(dept == dist.length){
                getFriends(distCase);
                return;
            }
            
            for(int i=0; i<dist.length; i++){
                if(!isVisted[i]){
                    isVisted[i] = true;
                    distCase[dept] = dist[i];
                    makeDistCases(dept+1, distCase, dist);
                    isVisted[i] = false;
                }
            }
        }
        
        private void getFriends(int[] distCase){
            // 취약점 배열 마지막 index
            int N = weakCaseList.get(0).length - 1;
            for(int[] wc : weakCaseList){
                
                int idx = 0; // 취약점 인덱스
                int cnt = 0; // 점검에 동원된 친구 수
                for(int d : distCase){
                    // wc[idx] 지점부터 친구가 점검 시작
                    cnt += 1;
                    // 한 친구가 점검가능한 최대 지점
                    int end = wc[idx] + d;
                    while(idx < N && wc[idx+1] <= end){
                        idx += 1;
                    }
                    
                    // 점검한 인덱스가 마지막 인덱스 일 경우
                    if(idx == N){
                        min = Math.min(min, cnt);
                        break;
                    }else{
                        idx += 1;
                    }
                }
            }
        }
    }
}
